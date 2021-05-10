package com.ex.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author yangzl 2021.05
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class ES_06_Doc_Delete {

    public static void main(String[] args) throws IOException {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        DeleteRequest request = new DeleteRequest();
        request.index("user").id("1001");
        esClient.delete(request, RequestOptions.DEFAULT);
        esClient.close();

    }
}
