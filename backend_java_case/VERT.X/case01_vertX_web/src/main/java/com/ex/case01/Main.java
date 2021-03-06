package com.ex.case01;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class Main {

    public static void main(String[] args) {
        //配置项
        VertxOptions options = new VertxOptions();
        options.setWorkerPoolSize(40);
        //大部分应用将只会需要一个Vert.x实例，但如果您有需要也可创建多个Vert.x实例，如：隔离的事件总线或不同组的客户端和服务器
        Vertx vertx = Vertx.vertx(options);
        //集群管理配置:
        Vertx.clusteredVertx(options, res->{
            if (res.succeeded()) {
                Vertx vertx1 = res.result(); //获取到了集群
            }
        });
    }
}
