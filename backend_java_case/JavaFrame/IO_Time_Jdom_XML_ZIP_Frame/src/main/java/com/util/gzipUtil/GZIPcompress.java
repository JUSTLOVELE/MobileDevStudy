package com.util.gzipUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {

	/**
	 * 压缩字符串
	 * @param str
	 * @param code:编码格式建议:ISO-8859-1
	 * @return
	 * @throws IOException
	 */
	public static String compress(String str, String code) throws IOException {

		if (str == null || str.length() == 0) {
			return str;
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(str.getBytes());
		gzip.close();

		return out.toString(code);
	}
}
