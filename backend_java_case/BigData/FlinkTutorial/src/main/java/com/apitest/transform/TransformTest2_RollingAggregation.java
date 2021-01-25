package com.apitest.transform;

import com.apitest.source.com.apitest.beans.SensorReading;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import javax.xml.crypto.Data;

/**
 * @author yangzl 2020.01.22
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class TransformTest2_RollingAggregation {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        DataStream<String> inputstream = env.readTextFile("C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\sensor.txt");
//        DataStream<SensorReading> dataStream = inputstream.map(new MapFunction<String, SensorReading>() {
//            @Override
//            public SensorReading map(String s) throws Exception {
//
//                String[] fields = s.split(",");
//                return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
//            }
//        });
        //上面方法是OK的下面介绍另一种
        DataStream<SensorReading> dataStream = inputstream.map(line -> {
                String[] fields = line.split(",");
                return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
        });
        //分组
        KeyedStream<SensorReading, Tuple> keyedStream = dataStream.keyBy("id");
        KeyedStream<SensorReading, Tuple> keyedStream1 = dataStream.keyBy("id");
        //滚动聚合,取当前最大的温度值
        DataStream<SensorReading> resultStream = keyedStream.max("temperature");
        resultStream.print();
        env.execute();
    }
}
