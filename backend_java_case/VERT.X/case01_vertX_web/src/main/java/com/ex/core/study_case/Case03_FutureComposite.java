package com.ex.core.study_case;

import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class Case03_FutureComposite {

    public static void main(String[] args) {

        Future<String> f1 = Future.future(future->{
            System.out.println("f1");
            future.complete("f1 result");
        });

        Future<String> f2 = Future.future(future->{
            System.out.println("f2");
            future.complete("f2 result");
        });

        Future<String> f3 = Future.future(future->{
            System.out.println("f3");
            //future.complete("f3 result");
            future.fail("f3 fail");
        });

        CompositeFuture.all(f1, f2, f3).onComplete(ar ->{
            if(ar.succeeded()) {
                System.out.println("all --- success");
            }else {
                System.out.println("all --- fail");
            }
        });

        CompositeFuture.any(f1, f2, f3).onComplete(ar ->{
            if(ar.succeeded()) {
                System.out.println("all --- success");
            }else {
                System.out.println("all --- fail");
            }
        });

        CompositeFuture.join(f1, f2, f3).onComplete(ar ->{
            if(ar.succeeded()) {
                System.out.println("all --- success");
            }else {
                System.out.println("all --- fail");
            }
        });
    }
}
