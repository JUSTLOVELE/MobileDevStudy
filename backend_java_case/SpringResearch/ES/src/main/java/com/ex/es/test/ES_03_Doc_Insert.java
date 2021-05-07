package com.ex.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author yangzl 2021.05.07
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class ES_03_Doc_Insert {

    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");
        User user = new User();
        user.setAge(30);
        user.setName("test");
        user.setSex("同性");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        request.source(json, XContentType.JSON);
        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }
}
