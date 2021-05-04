package com.ex.utils;

/**
 * @Description:文件工具类
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @Company: 福建互医科技有限公司
 * @author yangzl 2019-11-12
 * @version 1.00.00
 * @history:
 */
public class FileUtil {

	/**
	 * 获取文件名
	 * @param originalFilename
	 * @return
	 */
	public static String getFileName(String originalFilename) {
		
		 String name = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
		 return name;
	}
	
	/**
	 * 获取文件扩展名
	 * @param originalFilename
	 * @return
	 */
	public static String getExtName(String originalFilename) {
		
		String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1, originalFilename.length());
		return ext;
	}
}
