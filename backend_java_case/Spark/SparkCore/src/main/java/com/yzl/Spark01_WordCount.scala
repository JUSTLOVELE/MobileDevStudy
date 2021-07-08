package com.yzl

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
    val sparConf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext()
    //执行业务操作

    //关闭连接
    sc.stop()
  }
}
