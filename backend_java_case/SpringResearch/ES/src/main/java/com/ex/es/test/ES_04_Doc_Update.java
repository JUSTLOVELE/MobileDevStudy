package com.ex.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author yangzl 2021.05.07
 * @version 1.00.00
 * @Description:
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @Company: 福建互医科技有限公司
 * @history:
 */
public class ES_04_Doc_Update {

    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        UpdateRequest request = new UpdateRequest();
        request.index("user").id("1001");
        User user = new User();
        user.setAge(30);
        user.setName("test");
        user.setSex("同性");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        request.index("user").id("1001");//针对user的索引,id为1001的数据进行修改
        request.doc(XContentType.JSON, "sex", "女");
        UpdateResponse update = esClient.update(request, RequestOptions.DEFAULT);
        System.out.println(update.getResult());
    }
}
