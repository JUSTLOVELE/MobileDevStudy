package com.ex.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author yangzl 2021.05.06
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class ES_Client {

    public static void main(String[] args) {

        try {
            RestHighLevelClient client = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("localhost", 9200, "http")));

            client.close();
            System.out.println(client);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
