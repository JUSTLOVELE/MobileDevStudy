import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.api.scala._

/**
 * @author yangzl ${Date}
 * @version 1.00.00
 * @Description:
 * @history:
 */
object WordCount {

  def main(args: Array[String]): Unit = {
    //创建一个执行环境
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    //从文件中读取数据
    val inputPath = "/Users/yangzuliang/Documents/develop/github/MobileDevStudy/backend_java_case/BigData/FlinkTutorial/src/main/resources/hello.txt"
    //val inputPath: String = "C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\hello.txt"
    val inputDataSet: DataSet[String] = env.readTextFile(inputPath)
    //对数据进行转换处理统计,先分词,再按照word进行分组,最后进行聚合统计
    val resultDataSet: DataSet[(String, Int)] = inputDataSet
      .flatMap(_.split(" "))
      .map((_, 1))
      .groupBy(0)//以第一个元素作为key进行分组
      .sum(1) //对所有数据的第二个元素求和
    resultDataSet.print()
  }
}
