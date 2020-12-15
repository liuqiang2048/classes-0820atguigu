package com.atguigu.spark.rdd.wordcount

import org.apache.spark.{SparkConf, SparkContext}

object WordCount_1 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("app").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    val res: (Int, Int) = sc.makeRDD(List(("zhangsan", 20), ("lisi", 30), ("wangw", 40))).map {
      case (name, age) => {
        (age, 1)
      }
    }.reduce {
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2)
      }
    }
    println(res._1/res._2)
    // 关闭连接
    sc.stop()
  }

}
