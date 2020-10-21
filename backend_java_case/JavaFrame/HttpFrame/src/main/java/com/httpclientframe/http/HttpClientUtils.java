package com.httpclientframe.http;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;

import java.io.IOException;
import java.util.Random;

/**
 * 连接池
 * @author yangzuliang
 *
 */
public class HttpClientUtils {
	
	private static final Log _loggger = LogFactory.getLog(HttpClientUtils.class);
	private static PoolingClientConnectionManager cm = null;
	
	static {
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
		schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));

		cm = new PoolingClientConnectionManager(schemeRegistry);
		try {
			cm.setMaxTotal(200);
		} catch (NumberFormatException e) {
			_loggger.error("Key[httpclient.max_total] Not Found in systemConfig.properties", e);
		}
		// 每条通道的并发连接数设置（连接池）
		try {
			cm.setDefaultMaxPerRoute(50);
		} catch (NumberFormatException e) {
			_loggger.error("Key[httpclient.default_max_connection] Not Found in systemConfig.properties", e);
		}
	}
	
	static final int TIMEOUT = 20000;// 连接超时时间
	static final int SO_TIMEOUT = 60000;// 数据传输超时

	public static HttpClient getHttpClient() {
		HttpParams params = new BasicHttpParams();
		params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, Integer.valueOf(TIMEOUT));
		params.setParameter(CoreConnectionPNames.SO_TIMEOUT, Integer.valueOf(SO_TIMEOUT));
		return new DefaultHttpClient(cm, params);
	}

	public static void release() {
		if (cm != null) {
			cm.shutdown();
		}
	}

	public static void main(String[] args) throws ClientProtocolException, IOException {
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			long l1 = System.currentTimeMillis();
			HttpClient client = getHttpClient();

			HttpGet get = new HttpGet("http://www.baidu.com/s?wd=" + r.nextInt(5000));
			HttpResponse response = client.execute(get);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				long l = entity.getContentLength();
				System.out.println("回应结果长度:" + l);
			}
			System.out.println("查询耗时" + (System.currentTimeMillis() - l1));
		}
	}

}
