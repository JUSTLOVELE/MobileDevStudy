package com.case01.wc;

import com.util.PathUtil;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author yangzl 2020.12.25
 * @version 1.00.00
 * @Description:流处理word count,同批处理不同,流处理应该是启动好后等待事件,来一个处理一个,事件驱动型
 * @history:
 */
public class StreamWordCount {

    public static void main(String[] args) throws Exception {

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //设置并行度,默认是根据CPU的核数,4核就是4个线程
        env.setParallelism(4);
        //从文件中读取数据
        String inputPath = PathUtil.getHelloTxtInputPath();
        DataStreamSource<String> inputDataStream = env.readTextFile(inputPath);
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
