import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.api.scala._
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
/**
 * @author yangzl ${Date}
 * @version 1.00.00
 * @Description:
 * @history:
 */
//流处理 word count
object StreamWordCount {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    //线程数就是cpu的核心数
    //env.setParallelism(4)
    //接收一个socket文本流
    val inputDataStream: DataStream[String] = env.socketTextStream("localhost", 7777)
    //进行转化处理统计
    val resultDataStream: DataStream[(String, Int)] = inputDataStream
      .flatMap(_.split(" "))
      .filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(0)
      .sum(1)

    resultDataStream.print()
    //这里要启动一个进程,要不然就直接退出了
    env.execute("jobName-stream word count")
  }
}
