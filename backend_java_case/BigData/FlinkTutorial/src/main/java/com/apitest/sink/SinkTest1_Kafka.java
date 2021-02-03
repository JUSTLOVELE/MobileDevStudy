package com.apitest.sink;

import com.apitest.source.com.apitest.beans.SensorReading;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;

/**
 * @author yangzl 2021.02.03
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class SinkTest1_Kafka {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> inputstream = env.readTextFile("C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\sensor.txt");
        DataStream<String> dataStream = inputstream.map(line -> {
            String[] fields = line.split(",");
            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2])).toString();
        });

        dataStream.addSink(new FlinkKafkaProducer011<String>("localhost:9092", "sinktest", new SimpleStringSchema()));

        env.execute();
    }
}
