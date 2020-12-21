package com.sinkapitest

import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, createTypeInformation}
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011

object KakfaRead {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val properties = new Properties()
    properties.setProperty("bootstrap.servers", "localhost:9002")
    properties.setProperty("group.id", "consumer-group")
    val stream = env.addSource(new FlinkKafkaConsumer011[String]("sensor", new SimpleStringSchema()))
    val dataStream = stream.map(
      data => {
        val arr = data.split(",")
        SensorReading_03(arr(0), arr(1), arr(2).toDouble).toString
      }
    )

    env.execute("source test")
  }
}
