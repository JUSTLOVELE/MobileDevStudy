package com.ex.case01;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * 阻塞案例
 */
public class Case01_BlockCase {

    public static void main(String[] args) {

        Vertx vertx = VertxInitUtil.initVertxEnv();
        //调用executeBlocking会按照顺序执行,虽然1的阻塞时间更长,但它会等01执行完再执行02
        executeBlock01(vertx, 6000);
        executeBlock02(vertx, 1000);
        //如果把ordered设为false,那就不会按照顺序执行,就是并行执行
        executeBlock03(vertx, 3000);
    }

    public static void executeBlock01(Vertx vertx, long millis) {

        vertx.executeBlocking(future -> {

            try {
                Thread.sleep(millis);
            }catch (Exception e) {
                e.printStackTrace();
            }
            // 调用一些需要耗费显著执行时间返回结果的阻塞式API
            String result = "result";
            future.complete(result);
        }, res -> {
            System.out.println("The result is: " + res.result());
        });
    }

    public static void executeBlock02(Vertx vertx, long millis) {

        vertx.executeBlocking(future -> {

            try {
                Thread.sleep(millis);
            }catch (Exception e) {
                e.printStackTrace();
            }
            // 调用一些需要耗费显著执行时间返回结果的阻塞式API
            String result = "result22";
            future.complete(result);
        }, res -> {
            System.out.println("The result is: " + res.result());
        });
    }

    public static void executeBlock03(Vertx vertx, long millis) {

        vertx.executeBlocking(future -> {

            try {
                Thread.sleep(millis);
            }catch (Exception e) {
                e.printStackTrace();
            }
            // 调用一些需要耗费显著执行时间返回结果的阻塞式API
            String result = "result22";
            future.complete(result);
        }, false, res -> {
            System.out.println("The result is: " + res.result());
        });
    }
}
