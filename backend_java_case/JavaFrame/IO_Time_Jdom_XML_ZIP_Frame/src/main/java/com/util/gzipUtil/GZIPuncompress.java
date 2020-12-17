package com.util.gzipUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class GZIPuncompress {

	/**
	 * 解压缩字符串:
	 * @param str
	 * @param code:编码格式建议:ISO-8859-1
	 * @return
	 * @throws IOException
	 */
	public static String uncompress(String str, String code) throws IOException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes(code));
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[256];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}

		return out.toString();
	}
}
