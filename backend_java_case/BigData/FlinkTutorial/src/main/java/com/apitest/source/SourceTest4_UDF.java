package com.apitest.source;

import com.apitest.source.com.apitest.beans.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author yangzl 2020.01.19
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class SourceTest4_UDF {

    public static void main(String[] args) throws Exception {
        //如果要按顺序的话就要设置并行度为1才可以哦
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        //DataStreamSource<SensorReading> dataStream = env.readTextFile("C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\sensor.txt");
        DataStreamSource<SensorReading> dataStream = env.addSource(new MySourceFunction());
        dataStream.print();
        env.execute("jobName");
    }

    //实现自定义的SourceFunction
    public static class MySourceFunction implements SourceFunction<SensorReading> {
        //定义标识位,用来控制数据的产生
        private boolean running = true;

        @Override
        public void run(SourceContext<SensorReading> sourceContext) throws Exception {

            //定义一个随机数发生器
            Random random = new Random();

            Map<String, Double> sensorTempMap = new HashMap<>();

            for(int i=0; i<10; i++) {
                sensorTempMap.put("sensor_" + (i+1), 60 + random.nextGaussian() * 20);
            }

            while(running) {

                for(String sensorId: sensorTempMap.keySet()) {

                    //在当前温度基础上做一个随机波动
                    Double newTemp = sensorTempMap.get(sensorId) + random.nextGaussian();
                    sensorTempMap.put(sensorId, newTemp);
                    sourceContext.collect(new SensorReading(sensorId, System.currentTimeMillis(), newTemp));
                }
                //1秒输出方便观察
                Thread.sleep(1000L);
            }
        }

        @Override
        public void cancel() {
            running = false;
        }
    }
}
