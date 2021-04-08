package com.apitest.state;

import com.apitest.source.com.apitest.beans.SensorReading;
import org.apache.flink.runtime.state.filesystem.FsStateBackend;
import org.apache.flink.runtime.state.memory.MemoryStateBackend;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author yangzl 2021.04.08
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class StateTest4_FaultTolerance {

    public static void main(String[] args) throws Exception  {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
//        env.setStateBackend(new MemoryStateBackend());
//        env.setStateBackend(new FsStateBackend(""));
//        env.setStateBackend(new RocksDBStateBackend(""));
        DataStream<String> inputstream = env.readTextFile("C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\sensor.txt");
        DataStream<SensorReading> dataStream = inputstream.map(line -> {
            String[] fields = line.split(",");
            return new SensorReading(fields[0], new Long(fields[1]), new Double(fields[2]));
        });



        dataStream.print();
        env.execute();
    }
}
