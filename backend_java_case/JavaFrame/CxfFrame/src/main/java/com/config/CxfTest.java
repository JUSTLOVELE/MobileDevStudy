package com.config;

/**
 * @author yangzl 2020.10.28
 * @version 1.00.00
 * @Description:
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @history:
 */

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.junit.Test;

public class CxfTest {

    /*
     * HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
     * HTTPClientPolicy httpClientPolicy = httpConduit.getClient();
     * //解决Marshalling Error: Error writing request body to server
     * httpClientPolicy.setAllowChunking(false);
     * //如果setAllowchunking不行，可以试试setAutoRedirect
     * //httpClientPolicy.setAutoRedirect(true);
     */

    public void chaoshi() {

        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:9001/Test/service?wsdl");
        //一般超时是一分钟,如果一个请求在一分钟内没有结束,又来个新的请求,如此周而复始,CXF就会缓存起来,当数缓存太大时 就会挂掉
        HTTPConduit http = (HTTPConduit) client.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setAllowChunking(false); // 取消块编码
        httpClientPolicy.setConnectionTimeout(180 * 1000); // 连接超时3分钟
        httpClientPolicy.setReceiveTimeout(300 * 1000); // 响应超时
        http.setClient(httpClientPolicy);

    }

    @Test
    public void logTest() {

        try {

            JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
            Client client = dcf.createClient("http://localhost:9001/Test/service?wsdl");
            client.getInInterceptors().add(new LoggingInInterceptor());
            client.getOutInterceptors().add(new CDATAOutInterceptor());
            client.getOutInterceptors().add(new LoggingOutInterceptor());
            Object[] objs = new Object[2];
            objs[0] = "20";
            objs[1] = "张三";
            objs = client.invoke("method", objs);
            String s = objs[0].toString();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void commonTest() {

        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:9001/Test/service?wsdl");

        try {

            Object[] objs = new Object[2];
            objs[0] = "20";
            objs[1] = "张三";
            objs = client.invoke("method", objs);
            String s = objs[0].toString();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
