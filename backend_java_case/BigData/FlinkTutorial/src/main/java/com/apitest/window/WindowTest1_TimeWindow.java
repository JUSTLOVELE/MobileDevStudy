package com.apitest.window;

import com.apitest.source.com.apitest.beans.SensorReading;
import org.apache.commons.collections.IteratorUtils;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

/**
 * @author yangzl 2021.02.23
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class WindowTest1_TimeWindow {

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
        //开窗测试,15秒
        SingleOutputStreamOperator<Integer> result = dataStream.keyBy("id")
                //   .window(EventTimeSessionWindows.withGap(Time.minutes(10)))
                //  .countWindow(10, 2)
                //.window(TumblingProcessingTimeWindows.of(Time.seconds(15)))
                .timeWindow(Time.seconds(15))
                .aggregate(new AggregateFunction<SensorReading, Integer, Integer>() {
                    @Override
                    public Integer createAccumulator() {
                        return 0;
                    }

                    @Override
                    public Integer add(SensorReading sensorReading, Integer integer) {
                        return integer + 1;
                    }

                    @Override
                    public Integer getResult(Integer integer) {
                        return integer;
                    }

                    @Override
                    public Integer merge(Integer integer, Integer acc1) {
                        //这里不用合并,sessionwindow或者分区有用,这里蛮合并
                        return integer + acc1;
                    }
                });

        result.print();
        //全窗口函数
        SingleOutputStreamOperator<Tuple3<String, Long, Integer>> resultStream = dataStream.keyBy("id")
                .timeWindow(Time.seconds(15))
                .apply(new WindowFunction<SensorReading, Tuple3<String, Long, Integer>, Tuple, TimeWindow>() {
                    @Override
                    public void apply(Tuple tuple, TimeWindow timeWindow, Iterable<SensorReading> input, Collector<Tuple3<String, Long, Integer>> out) throws Exception {
                        String id = tuple.getField(0);//0对应id
                        Long windowEnd = timeWindow.getEnd();
                        Integer count = IteratorUtils.toList(input.iterator()).size();
                        out.collect(new Tuple3<>(id, windowEnd, count));
                    }
                });
        resultStream.print();
        env.execute();
    }
}
