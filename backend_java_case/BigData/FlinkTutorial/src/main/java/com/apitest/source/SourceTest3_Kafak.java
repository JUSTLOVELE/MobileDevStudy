package com.apitest.source;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;

import java.util.Properties;

/**
 * @author yangzl 2021.01.18
 * @version 1.00.00
 * @Description:
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @Company: 福建互医科技有限公司
 * @history:
 */
public class SourceTest3_Kafak {

    public static void main(String[] args) throws Exception {
        //如果要按顺序的话就要设置并行度为1才可以哦
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9002");
        properties.setProperty("group.id", "consumer-group");
        DataStreamSource<String> dataStream = env.addSource(new FlinkKafkaConsumer011<String>("sensor" , new SimpleStringSchema(), properties));
        dataStream.print();
        env.execute("jobName");
    }
}
