package com.case01.wc;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import scala.Int;

import java.util.Properties;

/**
 * @author yangzl 2020.12.24
 * @version 1.00.00
 * @Description:
 * @history:
 */
//批处理word count
public class WordCount {

    public static void main(String[] args) {

        Properties prop = System.getProperties();
        String os = prop.getProperty("os.name");
        System.out.println(os);
        //创建执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //从文件中读取数据
        String inputPath = null;

        if(os.startsWith("Windows")) {
            inputPath = "C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\hello.txt";
        }else{

        }

        DataSet<String> inputDataSet = env.readTextFile(inputPath);
        //对数据集进行处理,按空格分词展开,转换成(word,1)二元组进行统计
        DataSet<Tuple2<String, Integer>> result = inputDataSet.flatMap(new MyflatMapper())
                .groupBy(0)//按照第一个位置的word分组
                .sum(1) //将第二个位置上的数据求和
        ;

        try{
            result.print();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static class MyflatMapper implements FlatMapFunction<String, Tuple2<String, Integer>> {

        @Override
        public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) throws Exception {
            //按空格分词
            String[] words = s.split(" ");
            //遍历所有word,包成二元组输出
            for(String word: words) {
                collector.collect(new Tuple2<>(word, 1));
            }
        }
    }
}
