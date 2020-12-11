package com.ex.batchprocessing;

import org.springframework.batch.item.ItemProcessor;

/**
 * 第二步处理数据转为大写
 */
public class Processor implements ItemProcessor<String, String> {

    @Override
    public String process(String data) throws Exception {
        return data.toUpperCase();
    }

}