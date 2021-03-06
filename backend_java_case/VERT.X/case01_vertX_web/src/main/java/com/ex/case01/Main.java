package com.ex.case01;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

public class Main {

    public static void main(String[] args) {
        //配置项
        VertxOptions options = new VertxOptions();
        options.setWorkerPoolSize(40);
        //大部分应用将只会需要一个Vert.x实例，但如果您有需要也可创建多个Vert.x实例，如：隔离的事件总线或不同组的客户端和服务器
        Vertx vertx = Vertx.vertx(options);
        //集群管理配置:
//        Vertx.clusteredVertx(options, res->{
//            if (res.succeeded()) {
//                Vertx vertx1 = res.result(); //获取到了集群模式下的Vertx对象
//            }else{
//                //获取失败
//                System.out.println("没有集群配置");
//            }
//        });

        vertx.setPeriodic(1000, id->{
            System.out.println("每隔一秒调用一次");
        });

//        vertx.executeBlocking(future -> {
//            // 调用一些需要耗费显著执行时间返回结果的阻塞式API
//            String result = someAPI.blockingMethod("hello");
//            future.complete(result);
//        }, res -> {
//            System.out.println("The result is: " + res.result());
//        });

        HttpServer server = vertx.createHttpServer();
        server.requestHandler(request -> {
            // 所有的请求都会调用这个处理器处理
            HttpServerResponse response = request.response();
            response.putHeader("content-type", "text/plain");

            // 写入响应并结束处理
            response.end("Hello World!");
        });

        server.listen(8080);
    }
}
