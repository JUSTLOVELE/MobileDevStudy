import org.apache.flink.streaming.api.scala._

case class SensorReading(id: String, time: Long, temp: Double)

object SourceTEST {

  //按照不同的并行度读取数据，所以s1,s2,s3输出的顺序是会不一致的
  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    var dataList = List(
      SensorReading("s1", 1547718199, 35.8),
      SensorReading("s2", 1547718199, 36.8),
      SensorReading("s3", 1547718199, 37.8)
    )

    var stream1 = env.fromCollection(dataList)
    //    env.fromElements(1.0, 35, "hello")
    stream1.print()
    env.execute("source test")
  }

}



