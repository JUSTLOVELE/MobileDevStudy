import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.api.scala._
import sun.management.Sensor
/**
 * @author yangzl ${Date}
 * @version 1.00.00
 * @Description:
 * @Copyright: Copyright (c) 2017 HYKJ All Rights Reserved
 * @Company: 福建互医科技有限公司
 * @history:
 */
object WindowTest {

  def main(args: Array[String]): Unit = {
    //创建一个执行环境
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)
    //从文件中读取数据
    val inputPath: String = "C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\hello.txt"
    val inputDataSet: DataSet[String] = env.readTextFile(inputPath)
    var inputStream = env.readTextFile(inputPath)

  }
}
