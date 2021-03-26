package com.ex.core.study_case;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

import java.util.UUID;
import java.util.concurrent.CompletionStage;

public class Case04_ComletionStage {

    public static void main(String[] args) {

        Vertx vertx = VertxInitUtil.initVertxEnv();
        Future<String> future = vertx.createDnsClient().lookup("vertx.io");
        CompletionStage<String> completionStage = future.toCompletionStage().whenComplete((ip, err) -> {
            if (err != null) {
                System.out.println("Could not resolve vertx.io");
                //err.printStackTrace();
            } else {
                System.out.println("vertx.io => " + ip);
            }
        });

        Future.fromCompletionStage(completionStage, vertx.getOrCreateContext())
                .flatMap(str->{
                    String key = UUID.randomUUID().toString();
                    System.out.println(key);
                    Future<Object> objectFuture = Future.succeededFuture();
                    //return storeInDb(key, str)
                    return objectFuture;
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
