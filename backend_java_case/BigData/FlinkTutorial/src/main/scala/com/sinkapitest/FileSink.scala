package com.sinkapitest

import org.apache.flink.api.common.serialization.SimpleStringEncoder
import org.apache.flink.core.fs.Path
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.apache.flink.streaming.api.functions.sink.filesystem.StreamingFileSink

/**
 * @author yangzl ${Date}
 * @version 1.00.00
 * @Description:
 * @history:
 */

case class SensorReading_03(var id: String, var time: String, var temp: Double) {

  def this() {
    this(null, null, 0.0)
  }
}

/**
 * 输出
 */
object FileSink {

  def main(args: Array[String]): Unit = {

    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val inputPath: String = "C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\sensor.txt"
    val inputStream = env.readTextFile(inputPath)

    val dataStream = inputStream.map(
      data => {
        val arr = data.split(",")
        new SensorReading_03(arr(0), arr(1), arr(2).toDouble)
      }
    )

    dataStream.print()
    dataStream.addSink(StreamingFileSink.forRowFormat(new Path("C:\\logs"), new SimpleStringEncoder[SensorReading_03]()).build())


  }
}
