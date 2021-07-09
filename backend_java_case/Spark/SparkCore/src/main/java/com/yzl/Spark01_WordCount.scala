package com.yzl

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author yangzl ${Date}
 * @version 1.00.00
 * @Description:
 * @history:
 */
object Spark01_WordCount {

  def main(args: Array[String]): Unit = {
    //建立和Spark框架的连接
    //scala版本
    val sparkConf = new SparkConf()
    sparkConf.setMaster("local")   //本地单线程运行
    sparkConf.setAppName("testJob")
    val sc = new SparkContext(sparkConf)
    //执行业务操作
    //1、读取文件，获取一行一行的数据
    // hello world
    val lines: RDD[String] = sc.textFile("C:\\develop\\github\\MobileDevStudy\\backend_java_case\\Spark\\SparkCore\\src\\main\\resources")
    //2、将一行数据进行拆分，形成一个一个的单词
    // hello world => hello, world
    var words: RDD[String] = lines.flatMap(_.split(" "))//空格隔开分词
    //3、将数据根据单词进行分组，便于统计
    // (hello, hello), (world, world)
    var wordGroup: RDD[(String, Iterable[String])] = words.groupBy(word => word)
    //4、对分组后的数据进行转换
    // (hello, 2), (world, 2)
    val wordToCount = wordGroup.map {
      case (word, list) => {
        (word, list.size)
      }
    }

    var arrays: Array[(String, Int)] = wordToCount.collect()
    arrays.foreach(println)

    //关闭连接
    sc.stop()
  }
}
