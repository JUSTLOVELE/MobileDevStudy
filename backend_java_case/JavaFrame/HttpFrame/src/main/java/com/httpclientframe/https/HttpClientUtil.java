package com.httpclientframe.https;

/**
 * @author yangzl 2020.10.21
 * @version 1.00.00
 * @Description: httpClient调用https
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @history:
 */

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    public static void main(String[] args){

        //case01利用httpClient调用https并传递参数
        Map<String, String> param = new HashMap<String, String>();
        param.put("param1", "client_credentials");
        param.put("param2", "6be9ae520db14b1a8c9fb7eace72b964");
        param.put("param3", "jjcafWdHhg*FBDCK");
        String url = "https://fwzx.fjzwt.cn:28063/bcsp/backend/oauth/token";
        String httpOrgCreateTestRtn = HttpClientUtil.doPostCase01(url, "utf-8", param);
        System.out.println(httpOrgCreateTestRtn);
    }


    @SuppressWarnings("resource")
    public static String doPostCase01(String url, String charset, Map<String, String> param){
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{

            List<NameValuePair> list = new ArrayList<NameValuePair>();
//            list.add(new BasicNameValuePair("param1", "client_credentials"));
//            list.add(new BasicNameValuePair("param2", "6be9ae520db14b1a8c9fb7eace72b964"));
//            list.add(new BasicNameValuePair("param3", "jjcafWdHhg*FBDCK"));

            for(Map.Entry<String, String> entry: param.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpPost.setEntity(new UrlEncodedFormEntity(list, charset));
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("resource")
    public static String doPostCase02(String url,String jsonstr,String charset){
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json");
            StringEntity se = new StringEntity(jsonstr);
            se.setContentType("text/json");
            se.setContentEncoding(new BasicHeader("Content-Type", "application/json"));
            httpPost.setEntity(se);
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}