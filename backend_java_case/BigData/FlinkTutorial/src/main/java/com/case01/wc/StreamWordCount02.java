package com.case01.wc;

import com.util.PathUtil;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author yangzl 2020.12.28
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class StreamWordCount02 {

    public static void main(String[] args) throws Exception {

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //设置并行度,默认是根据CPU的核数,4核就是4个线程
        env.setParallelism(1);
        //等待输入的数据
        //利用ubuntu启用nc -lk 7777
        DataStream<String> inputDataStream = env.socketTextStream("127.0.0.1", 7777);
        //基于数据流进行转换计算
        SingleOutputStreamOperator<Tuple2<String, Integer>> result = inputDataStream.flatMap(new WordCount.MyflatMapper())
                .keyBy(0)
                .sum(1);
        result.print();
        /**
         * 执行任务,流处理,来一个处理一个,这里是有状态的流式处理
         * 会保存数据结果,(hello,1),(hello,2)...按顺序打印出来
         * 所以先保存了(hello,1),然后再用hello,1更新到了2
         */
        env.execute();
    }
}
