package com.soap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SoapConnectionUtil {

	public String request(String wsUrl, String sendMsg) throws Exception {

		URL url = new URL(wsUrl);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestProperty("Content-Length", String.valueOf(sendMsg.getBytes().length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestMethod("POST");
		// URL连接可用于输入/输出,设为true表示使用,false就是不使用
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		// 进行HTTP请求
		OutputStream outObject = httpConn.getOutputStream();
		outObject.write(sendMsg.getBytes());
		// 关闭输出流
		outObject.close();
		// 获取HTTP响应数据
		InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), "utf-8");
		BufferedReader inReader = new BufferedReader(isr);
		StringBuffer result = new StringBuffer();
		String inputLine = null;

		while ((inputLine = inReader.readLine()) != null) {
			result.append(inputLine);
		}

		httpConn.disconnect();
		inReader.close();
		isr.close();

		return result.toString();
	}
}
