package com.httpclientframe.jks;

import org.junit.Test;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

class TrustAnyVerifier implements HostnameVerifier{
	 
    public boolean verify(String hostname, SSLSession session) {
        System.out.println(">>> " + hostname + " " + session);
        return true;
    }
 
}

public class PointSSLClient {

	@Test
	public void getTest(){
		
		try {
			//要先导出证书 keytool -import -file D:/tomcat.cer -keystore D:\client.jks
			//new HttpsRequest().sendGet("https://localhost:8443/HAS/loginAction/testBase64.do?s=yzl");
			new PointSSLClient().sendPost("https://123.207.246.32:8443/HAS/loginAction/testBase64.do", "s=yzl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendPost(String address, String param) throws Exception{
		// 设置客户端信任证书
        System.setProperty("javax.net.ssl.trustStore", "D:\\client.jks");
        System.setProperty("javax.net.ssl.trustStorePassword","yclycl");
        // 主机名称验证策略
        HttpsURLConnection.setDefaultHostnameVerifier(new TrustAnyVerifier());
        URL realUrl = new URL(address);
		// 打开和URL之间的连接
		URLConnection conn = realUrl.openConnection();
		// 设置通用的请求属性
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		// 发送POST请求必须设置如下两行
		conn.setDoOutput(true);
		conn.setDoInput(true);
		// 获取URLConnection对象对应的输出流
		PrintWriter out = new PrintWriter(conn.getOutputStream());
		// 发送请求参数
		out.print(param);
		// flush输出流的缓冲
		out.flush();
		// 定义BufferedReader输入流来读取URL的响应
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		String result = "";
		while ((line = in.readLine()) != null) {
			result += line;
		}
        
		System.out.println(result);
	}
	
	
	public void sendGet(String address) throws Exception{
		// 设置客户端信任证书
        System.setProperty("javax.net.ssl.trustStore", "D:\\client.jks");
        System.setProperty("javax.net.ssl.trustStorePassword","yclycl");
        // 主机名称验证策略
        HttpsURLConnection.setDefaultHostnameVerifier(new TrustAnyVerifier());
        URL url = new URL(address);
        String result = "";
		BufferedReader in = null;
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("accept", "*/*");
		connection.setRequestProperty("connection", "Keep-Alive");
		connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		// 建立实际的连接
		connection.connect();
		// 获取所有响应头字段
		Map<String, List<String>> map = connection.getHeaderFields();
		// 遍历所有的响应头字段
		for (String key : map.keySet()) {
			System.out.println(key + "--->" + map.get(key));
		}
		// 定义 BufferedReader输入流来读取URL的响应
		in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}
		
		System.out.println(result);
	}
}
