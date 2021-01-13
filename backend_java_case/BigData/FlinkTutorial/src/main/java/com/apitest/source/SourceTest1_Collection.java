package com.apitest.source;

import com.apitest.source.com.apitest.beans.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;

/**
 * @author yangzl 2020.01.13
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class SourceTest1_Collection {

    public static void main(String[] args) throws Exception {
        //如果要按顺序的话就要设置并行度为1才可以哦
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<SensorReading> dataStream = env.fromCollection(Arrays.asList(
                new SensorReading("sensor_1", 1547718199L, 35.8),
                new SensorReading("sensor_6", 1547718199L, 15.4),
                new SensorReading("sensor_7", 1547718199L, 6.7),
                new SensorReading("sensor_10", 1547718199L, 38.1)
        ));

        DataStreamSource<Integer> integerDataStreamSource = env.fromElements(1, 2, 4, 67, 189);
        dataStream.print("dataStream");
        integerDataStreamSource.print("integerDataStreamSource");
        env.execute("jobName");
    }
}
