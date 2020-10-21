package com.httpclientframe.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class Request {

	@Test
	public void getRequest() throws Exception{
		
		HttpClient httpClient = HttpClientUtils.getHttpClient();
		HttpGet httpGet = new HttpGet("https://www.baidu.com");
		HttpResponse response = httpClient.execute(httpGet);
		
		if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
			
			HttpEntity entity = response.getEntity();
			
			if(entity != null){
				
				String html = EntityUtils.toString(entity, "utf-8");
			    System.out.println(html);
			}
		}
		
		EntityUtils.consume(response.getEntity());
	}
	
	public void postSendSoap(){
		
		HttpClient httpClient = HttpClientUtils.getHttpClient();
		HttpPost httpPost = new HttpPost("http://localhost:9001/Test/service");
		String returnSoap = null;
		
		try {
			
			StringEntity entity = new StringEntity("soapmessage", "utf-8");
			entity.setContentType("text/xml;charset=gbk");
			httpPost.setEntity(entity);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			
			if (entity != null) {
				returnSoap = EntityUtils.toString(httpEntity, "utf-8");
			}
			
			EntityUtils.consume(httpResponse.getEntity());
			System.out.println(returnSoap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
