package com.ex.core.study_case;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;

/**
 * 在quickstart例子中可以看到，创建一个类通过继承AbstractVerticle，
 * 然后重写start方法来创建http服务，这样做可以让http服务的生命周期完全由verticle管理。
 * AbstractVerticle类里面有两个属性，分别是Vertx和Context的对象，
 * 开发者在继承AbstractVerticle的子类里面可以直接使用这两个对象。
 * 例如vertx可以创建定时任务，向event bus中推送消息之类的事情。
 * context可以存储公用数据，像servlet里面的HttpServletRequest、Session、ApplicationContext这些对象，
 * 在请求一个url时保存数据，在请求另一个url时再将数据取出来。
 * 看一个context对象的使用例子，在请求/路径，向context对象存放name=zhangsan数据。在请求/user拿到name值，并显示到页面上。
 */
public class Case05_MyVerticle extends AbstractVerticle {

    private HttpServer server;

    /**
     * 通常要重写Start
     * @throws Exception
     */
    @Override
    public void start() throws Exception {
        super.start();
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        server = vertx.createHttpServer().requestHandler(req -> {
           req.response().putHeader("content-type", "text/plain").end("hello from vertx");
        });

        server.listen(8081, res->{

            if(res.succeeded()) {
                startPromise.complete();
            }else {
                startPromise.fail(res.cause());
            }
        });
    }

    /**
     * 根据实际情况覆盖stop
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
