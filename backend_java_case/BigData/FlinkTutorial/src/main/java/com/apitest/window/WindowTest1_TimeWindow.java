package com.apitest.window;

import com.apitest.source.com.apitest.beans.SensorReading;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.EventTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

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
        DataStream<String> inputstream = env.readTextFile("C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\sensor.txt");
        DataStream<SensorReading> dataStream = inputstream.map(line -> {
            String[] fields = line.split(",");
            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
        });
        //开窗测试,15秒
        dataStream.keyBy("id")
                .window(EventTimeSessionWindows.withGap(Time.minutes(10)));
              //  .countWindow(10, 2);
               // .timeWindow(Time.seconds(15));
                //.window(TumblingProcessingTimeWindows.of(Time.seconds(15)));
        env.execute();
    }
}
