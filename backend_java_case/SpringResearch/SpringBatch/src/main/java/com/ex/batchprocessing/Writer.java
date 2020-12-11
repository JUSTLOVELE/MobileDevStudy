package com.ex.batchprocessing;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

/**
 * 第三步写出控制台
 */
public class Writer implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> messages) throws Exception {
        for (String msg : messages) {
            System.out.println("Writing the data " + msg);
        }
    }

}