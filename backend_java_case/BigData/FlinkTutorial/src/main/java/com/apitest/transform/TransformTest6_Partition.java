package com.apitest.transform;

import com.apitest.source.com.apitest.beans.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author yangzl 2021.02.02
 * @version 1.00.00
 * @Description: 重分区
 * @history:
 */
public class TransformTest6_Partition {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(4);
        DataStream<String> inputstream = env.readTextFile("C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\sensor.txt");
        DataStream<SensorReading> dataStream = inputstream.map(line -> {
            String[] fields = line.split(",");
            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
        });

        DataStream<String> shuffle = inputstream.shuffle();
        shuffle.print();
        dataStream.keyBy("id");
        dataStream.print("input");
        env.execute();
    }
}
