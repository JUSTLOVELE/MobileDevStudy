package com.apitest.window;

import com.apitest.source.com.apitest.beans.SensorReading;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import scala.Tuple2;

/**
 * @author yangzl 2021.02.26
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class WindowTest2_CountWindow {


    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        //DataStream<String> inputstream = env.readTextFile("C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\sensor.txt");
        //nc -lk 7777
        DataStreamSource<String> inputstream = env.socketTextStream("localhost", 7777);
        DataStream<SensorReading> dataStream = inputstream.map(line -> {
            String[] fields = line.split(",");
            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
        });
        //开计数窗口测试
        SingleOutputStreamOperator<Double> avgTempResultStream = dataStream.keyBy("id")
                .countWindow(10, 2)//10个数位一个窗口，然后隔2个数滑动
                .aggregate(new MyAvgTemp());

        avgTempResultStream.print();
        env.execute();
    }

    /**
     * 要求平均值除了有值还得有个数,所以才会设计一个Tuple2<Double,Integer>
     */
    public static class MyAvgTemp implements AggregateFunction<SensorReading, Tuple2<Double, Integer>,Double> {

        @Override
        public Tuple2<Double, Integer> createAccumulator() {
            return new Tuple2<>(0.0, 0);
        }

        @Override
        public Tuple2<Double, Integer> add(SensorReading value, Tuple2<Double, Integer> accumulator) {
            return new Tuple2<>(accumulator._1 + value.getTemperature(), accumulator._2);
        }

        @Override
        public Double getResult(Tuple2<Double, Integer> accumulator) {
            return accumulator._1 / accumulator._2;
        }

        @Override
        public Tuple2<Double, Integer> merge(Tuple2<Double, Integer> a, Tuple2<Double, Integer> b) {
            return new Tuple2<>(a._1 + b._1, a._2 + b._2);
        }
    }
}
