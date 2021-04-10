package com.ex.core.study_case;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

import java.util.UUID;
import java.util.concurrent.CompletionStage;

/**
 * 阶段任务，在一个future完成后执行
 */
public class Case04_ComletionStage {

    public static void main(String[] args) {

        Vertx vertx = VertxInitUtil.initVertxEnv();
        //Future<String> future = vertx.createDnsClient().lookup("vertx.io");
        Future<String> future = Future.future(f->{
            System.out.println("f1");
            f.complete("f1 result");
        });
        CompletionStage<String> completionStage = future.toCompletionStage().whenComplete((result, err) -> {
            if (err != null) {
                System.out.println("Could not resolve vertx.io");
                err.printStackTrace();
            } else {
                System.out.println("vertx.io => " + result);
            }
        });

        Future.fromCompletionStage(completionStage, vertx.getOrCreateContext())
                .flatMap(str->{
                    String key = UUID.randomUUID().toString();
                    System.out.println(key);
                    //return storeInDb(key, str)
                    return future;
                })
                .onSuccess(str->{
                    System.out.println("We have a result: " + str);
                })
                .onFailure(err -> {
                    System.out.println("We have a problem");
                    err.printStackTrace();
                });
    }
}
