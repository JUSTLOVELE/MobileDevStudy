package com.ex.utils;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:word转pdf工具类
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @Company: 福建互医科技有限公司
 * @author wangdh 2019-2-18
 * @version 1.00.00
 * @history:
 */
public class Doc2HtmlUtil {
	
	private static Doc2HtmlUtil doc2HtmlUtil;
	
	private final static Log _logger = LogFactory.getLog(Doc2HtmlUtil.class);
	
	public static synchronized Doc2HtmlUtil getDoc2HtmlUtilInstance() {
		if(doc2HtmlUtil==null) {
			doc2HtmlUtil=new Doc2HtmlUtil();
		}
		return doc2HtmlUtil;
	}
	 /*** 转换文件成pdf */
	public String file2pdf(InputStream fromFileInputStream,String toFilePath,String type,String fileName) throws IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timesuffix = sdf.format(date);
		String docFileName = null;
        String htmFileName = null;
        if(".doc".equals(type)) {
        	 docFileName = "doc_" + timesuffix + ".doc";
             htmFileName = fileName + ".pdf";
        }else if(".docx".equals(type)) {
        	 docFileName = "docx_" + timesuffix + ".docx";
             htmFileName = fileName + ".pdf";
        }else {
        	return null;
        }
        File htmlOutputFile = new File(toFilePath + File.separatorChar + htmFileName);
        File docInputFile = new File(toFilePath + File.separatorChar + docFileName);
        if (htmlOutputFile.exists())
            htmlOutputFile.delete();
        htmlOutputFile.createNewFile();
        if (docInputFile.exists())
            docInputFile.delete();
        docInputFile.createNewFile();
        /*** 由fromFileInputStream构建输入文件  */
        try {
        	OutputStream os = new FileOutputStream(docInputFile);
            int bytesRead = 0;
            byte[] buffer = new byte[1024 * 8];
            while ((bytesRead = fromFileInputStream.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            } 
            os.close();
            fromFileInputStream.close();
        }catch (Exception e) {
        	_logger.error("", e);        	
		}
     // 连接服务
        OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
        try {
            connection.connect();
        } catch (ConnectException e) {
            System.err.println("文件转换出错，请检查OpenOffice服务是否启动。");
        }
     // convert 转换
        DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
        converter.convert(docInputFile, htmlOutputFile);
        connection.disconnect();
        // 转换完之后删除word文件
        docInputFile.delete();                                                                
        return htmFileName;
	}
	
	public static void main(String[] args) throws Exception {
		Doc2HtmlUtil coc2HtmlUtil = getDoc2HtmlUtilInstance ();
        File file = null;
        FileInputStream fileInputStream = null;
        file = new File("D:/test/vue.docx");
        fileInputStream = new FileInputStream(file);
        coc2HtmlUtil.file2pdf(fileInputStream, "D:/test",".docx","vue");
	}
}
