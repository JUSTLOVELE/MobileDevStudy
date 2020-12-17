package com.util.io;

public class CodeCovert {

	public static void main(String[] args) {
		
		System.out.println(utf8Togb2312("你好"));
	}
	
	
	
	public static String utf8Togb2312(String str) {
		
		try {
			byte[] bytesGB2312 = str.getBytes("GB2312");
			String newStrGB = new String(bytesGB2312, "GB2312");
			return newStrGB;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
