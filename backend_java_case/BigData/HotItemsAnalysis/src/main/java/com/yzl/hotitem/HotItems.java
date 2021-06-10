package com.yzl.hotitem;

import com.yzl.hotitem.model.ItemViewCount;
import com.yzl.hotitem.model.UserBehavior;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.timestamps.AscendingTimestampExtractor;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

/**
 * @author yangzl 2021.06.10
 * @version 1.00.00
 * @Description:
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @Company: 福建互医科技有限公司
 * @history:
 */
public class HotItems {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        //定义时间语义
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        //2.读取数据创建dataStream
        DataStream<String> inputStream = env.readTextFile("C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\HotItemsAnalysis\\src\\main\\resources\\UserBehavior.csv");
        //转换为POJO,分配时间戳和watermark
        DataStream<UserBehavior> dataStream = inputStream.map(line -> {

            String[] fields = line.split(",");
            return new UserBehavior(
                    new Long(fields[0]),
                    new Long(fields[1]),
                    new Integer(fields[2]),
                    fields[3],
                    new Long(fields[4])
                    );
        }).assignTimestampsAndWatermarks(new AscendingTimestampExtractor<UserBehavior>() {
            @Override
            public long extractAscendingTimestamp(UserBehavior userBehavior) {
                return userBehavior.getTimestamp() * 1000L;
            }
        });
        //分组开窗聚合,得到每个窗口内各个商品的count值
        DataStream<ItemViewCount> windowAggStream = dataStream.filter(
                data -> "pv".equals(data.getBehavior()) //过滤pv行为
        ).keyBy("itemId") //按商品id分组
        .timeWindow(Time.hours(1), Time.minutes(5)) //开滑窗
        .aggregate(new ItemCountAgg(), new WindowItemCountResult());

        env.execute("hot items analysis");
    }

    public static class ItemCountAgg implements AggregateFunction<UserBehavior, Long, Long> {

        @Override
        public Long createAccumulator() {
            return 0L;
        }

        @Override
        public Long add(UserBehavior userBehavior, Long aLong) {
            return aLong+1;
        }

        @Override
        public Long getResult(Long aLong) {
            return aLong;
        }

        @Override
        public Long merge(Long aLong, Long acc1) {
            return aLong + acc1;
        }
    }

    //自定义全窗口函数
    public static class WindowItemCountResult implements WindowFunction<Long, ItemViewCount, Tuple, TimeWindow> {

        @Override
        public void apply(Tuple tuple, TimeWindow timeWindow, Iterable<Long> iterable, Collector<ItemViewCount> collector) throws Exception {

            Long itemId = tuple.getField(0);
            Long windowEnd = timeWindow.getEnd();
            Long count = iterable.iterator().next();
            collector.collect(new ItemViewCount(itemId, windowEnd, count));
        }
    }
}
