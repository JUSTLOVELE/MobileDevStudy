package com.ex.core.study_case;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class Case06_Deployment {

    public static void main(String[] args) {

        Vertx vertx = VertxInitUtil.initVertxEnv();
        vertx.deployVerticle("com.ex.core.study_case.Case05_MyVerticle", res->{
            if(res.succeeded()) {
                System.out.println(res.result());
            }else{
                System.out.println("fail");
            }
        });
        //移除
        //        vertx.undeploy()
        DeploymentOptions options = new DeploymentOptions().setInstances(16);
        vertx.deployVerticle("com.ex.core.study_case.Case05_MyVerticle", options);
    }
}
