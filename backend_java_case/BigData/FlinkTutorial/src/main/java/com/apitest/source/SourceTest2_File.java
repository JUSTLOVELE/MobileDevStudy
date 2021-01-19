package com.apitest.source;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author yangzl 2020.01.18
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class SourceTest2_File {

    public static void main(String[] args) throws Exception {
        //如果要按顺序的话就要设置并行度为1才可以哦
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        DataStreamSource<String> dataStream = env.readTextFile("C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\sensor.txt");
        dataStream.print();
        env.execute("jobName");
    }
}
