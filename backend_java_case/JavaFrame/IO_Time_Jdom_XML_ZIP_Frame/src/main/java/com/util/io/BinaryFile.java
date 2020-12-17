package com.util.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读取二进制文件
 * @author yangzuliang
 *
 */
public class BinaryFile {

	/**
	 * 读取二进制文件
	 * @param bFile
	 * @return
	 * @throws IOException
	 */
	public static byte[] read(File bFile) throws IOException{
		
		BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
	    try {
			byte[] data = new byte[bf.available()];
			bf.read(data);
			return data;
		} finally {
			bf.close();
		}
	}
	
	/**
	 * 读取二进制文件
	 * @param bFile
	 * @return
	 * @throws IOException
	 */
	public static byte[] read(String bFile) throws IOException{
		return read(new File(bFile).getAbsoluteFile());
	}
}
