package com.apitest.state;

import com.apitest.source.com.apitest.beans.SensorReading;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author yangzl 2021.03.29
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class StateTest01_OperatorState {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        DataStream<String> inputstream = env.readTextFile("C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\sensor.txt");
        DataStream<SensorReading> dataStream = inputstream.map(line -> {
            String[] fields = line.split(",");
            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
        });
        //定义一个有状态的map操作,统计当前分区数据个数
        SingleOutputStreamOperator<Integer> resultStream = dataStream.map(new MyCounterMapper());
        resultStream.print();
        env.execute();
    }

    public static class MyCounterMapper implements MapFunction<SensorReading, Integer> {
        //算子状态
        private Integer count = 0;
        @Override
        public Integer map(SensorReading sensorReading) throws Exception {
            count++;
            return count;
        }
    }
}

