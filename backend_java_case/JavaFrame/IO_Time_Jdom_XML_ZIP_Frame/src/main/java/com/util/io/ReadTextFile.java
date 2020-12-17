package com.util.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 读取文本
 * @author yangzuliang
 *
 */
public class ReadTextFile {

	public String readText(String address, String code){
		
		StringBuffer sb = new StringBuffer();
		InputStreamReader inputStreamReader = null;
		FileInputStream fileInputStream = null;
		BufferedReader bufferedReader = null;
		try {
			
			File file = new File(address);
			fileInputStream = new FileInputStream(file);
			inputStreamReader = new InputStreamReader(fileInputStream, code);
			bufferedReader = new BufferedReader(inputStreamReader);
			String lineText = null;

			while ((lineText = bufferedReader.readLine()) != null) {
				sb.append(lineText);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			try {
				if(bufferedReader != null){
					bufferedReader.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if(inputStreamReader != null){
					inputStreamReader.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if(fileInputStream != null){
					fileInputStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
		
		return sb.toString();
	}
}
