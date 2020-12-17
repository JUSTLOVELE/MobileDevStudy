package com.util.zipUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * 压缩
 * @author yangzuliang
 *
 */
@Deprecated
public class ZipCompress {

	
	public static String compress(String str) throws IOException{
		
		if(str == null || str.length() == 0){
			return str;
		}
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(str.getBytes());
		gzip.close();
		
		return out.toString("ISO-8859-1");
	}
}
