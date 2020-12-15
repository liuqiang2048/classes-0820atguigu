package com.atguigu.spark.rdd.ready

import org.apache.spark.{SparkConf, SparkContext}

object Spark23_RDD_method {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)


    val rdd = sc.makeRDD(
      List(("b",5),("a",1),("b",2),("a",4),("a",3))
    )



  }
}
