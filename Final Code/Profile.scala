import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object Profile {
  def main(args: Array[String]) {
    
    val conf = new SparkConf().setAppName("Application").setMaster("local[*]")
    val sc = new SparkContext(conf)  
    val bully = sc.textFile("C:/Users/km327/Desktop/Books/BDAD/Project/Datasets/bully.txt").map(line => (line.split('\t')(1),line.split('\t')(2).toDouble))
    val FV = sc.textFile("C:/Users/km327/Desktop/Books/BDAD/Project/Datasets/FV.txt").map(line => (line.split(' ')(0),(line.split(' ')(5).toDouble,line.split(' ')(6).toDouble)))
    val JoinedRDD = bully.join(FV)
    val res = JoinedRDD.sortBy(t => t._2._1)
    val final_res = res.map { t => 
      t._1 + '\t' + t._2._1 + '\t' + t._2._2._1 + '\t' + t._2._2._2
    }
    final_res.saveAsTextFile("C:/Users/km327/Desktop/Books/BDAD/Project/Datasets/output")
  }
  
  
}