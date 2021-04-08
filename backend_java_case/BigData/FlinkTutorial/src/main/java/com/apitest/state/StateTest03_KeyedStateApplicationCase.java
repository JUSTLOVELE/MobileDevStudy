package com.apitest.state;

import com.apitest.source.com.apitest.beans.SensorReading;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;
import scala.Tuple3;

public class StateTest03_KeyedStateApplicationCase {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        DataStream<String> inputstream = env.readTextFile("C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\sensor.txt");
        DataStream<SensorReading> dataStream = inputstream.map(line -> {
            String[] fields = line.split(",");
            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
        });
        dataStream.keyBy("id")
                .flatMap(new TempChangeWarning(10.0));

        dataStream.print();
        env.execute();
    }

    public static class TempChangeWarning extends RichFlatMapFunction<SensorReading, Tuple3<String, Double, Double>> {

        //私有属性,温度跳变阈值
        private Double threshold;

        public TempChangeWarning(Double threshold) {
            this.threshold = threshold;
        }

        private ValueState<Double> lastTempState;

        @Override
        public void open(Configuration parameters) throws Exception {
            lastTempState = getRuntimeContext().getState(new ValueStateDescriptor<Double>("last-temp", Double.class));
        }

        @Override
        public void flatMap(SensorReading sensorReading, Collector<Tuple3<String, Double, Double>> collector) throws Exception {

            Double lastTemp = lastTempState.value();

            if(lastTemp != null) {

                Double diff = Math.abs(sensorReading.getTemperature() - lastTemp);

                if(diff >= threshold) {

                    collector.collect(new Tuple3<>(sensorReading.getId(), lastTemp, sensorReading.getTemperature()));
                }
            }
            //更新状态
            lastTempState.update(sensorReading.getTemperature());
        }
    }
}
