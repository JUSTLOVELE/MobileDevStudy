package com.apitest

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment

case class SensorReading_02(var id: String, var time: String, var temp: Double) {

  def this() {
    this(null, null, 0.0)
  }
}

class WordWithCount(var word: String, var count: Int) {
  def this() {
    this(null, -1)
  }
}


object TransformTest {

  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    //如果不设置并行度为1,它就会多核运行,只能保证单核是最小的
    env.setParallelism(1)
    val inputPath = "/Users/yangzuliang/Documents/develop/github/MobileDevStudy/backend_java_case/BigData/FlinkTutorial/src/main/resources/sensor.txt"
    val inputStream = env.readTextFile(inputPath)
    val dataStream = inputStream.map(
      data => {
        val arr = data.split(",")
        new SensorReading_02(arr(0), arr(1), arr(2).toDouble)
      }
    )

//    val aggStream = dataStream
//      .keyBy("id")
//      .min("temp")
//
//    aggStream.print()


    val input = env.fromElements(
      new WordWithCount("hello", 1),
      new WordWithCount("world", 2)// Case Class Data Set
    )

    input.keyBy("word").print()
    dataStream.keyBy("id").min("temp").print()
    env.execute("transform test")


  }
}
