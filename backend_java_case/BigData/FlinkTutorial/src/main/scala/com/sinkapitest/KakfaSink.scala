package com.sinkapitest

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011

object KakfaSink {

  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val inputPath = "/Users/yangzuliang/Documents/develop/github/MobileDevStudy/backend_java_case/BigData/FlinkTutorial/src/main/resources/sensor.txt"
    val inputStream = env.readTextFile(inputPath)

    val dataStream = inputStream.map(
      data => {
        val arr = data.split(",")
        SensorReading_03(arr(0), arr(1), arr(2).toDouble).toString
      }
    )

    dataStream.addSink(new FlinkKafkaProducer011[String]("localhost:9092", "sinktest", new SimpleStringSchema()))
    env.execute("kafka sink test")
  }

}
