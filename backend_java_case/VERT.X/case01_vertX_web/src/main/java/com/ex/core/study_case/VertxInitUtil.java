package com.ex.core.study_case;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class VertxInitUtil {

    public static Vertx initVertxEnv() {
        //配置项
        VertxOptions options = new VertxOptions();
        options.setWorkerPoolSize(40);
        //大部分应用将只会需要一个Vert.x实例，但如果您有需要也可创建多个Vert.x实例，如：隔离的事件总线或不同组的客户端和服务器
        Vertx vertx = Vertx.vertx(options);
        return vertx;
    }
}
