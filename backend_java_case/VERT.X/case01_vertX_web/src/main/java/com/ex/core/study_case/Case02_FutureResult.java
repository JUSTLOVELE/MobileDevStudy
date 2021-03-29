package com.ex.core.study_case;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileProps;
import io.vertx.core.file.FileSystem;

public class Case02_FutureResult {

    public static void main(String[] args) {

        Vertx vertx = VertxInitUtil.initVertxEnv();
        FileSystem fs = vertx.fileSystem();
        String path = "/Users/yangzuliang/Documents/develop/github/MobileDevStudy/backend_java_case/VERT.X/case01_vertX_web/src/main/resources";

        Future<FileProps> future = fs.props(path + "/my_file.txt");

        future.onComplete((AsyncResult<FileProps> ar) -> {
            if (ar.succeeded()) {
                FileProps props = ar.result();
                System.out.println("File size = " + props.size());
            } else {
                System.out.println("Failure: " + ar.cause().getMessage());
            }
        });

        Future<Void> future2 = fs
                .createFile(path + "/foo.txt")
                .compose(v -> {
                    // When the file is created (fut1), execute this:
                    System.out.println("compose");
                    return fs.writeFile(path + "/foo.txt", Buffer.buffer().appendString("ok"));
                })
                .compose(v -> {
                    // When the file is written (fut2), execute this:
                    return fs.move(path + "/foo.txt", path + "/bar.txt");
                });
    }
}
