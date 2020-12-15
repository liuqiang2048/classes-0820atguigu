package com.atguigu.spark.rdd.acc

import org.apache.spark.{SparkConf, SparkContext}

object Spark02_acc_wordcount {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster(
      "local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val rdd1=sc.makeRDD(
      List(
        ("a",1),("b",2)
      )
    )
    val rdd2=sc.makeRDD(
      List(
        ("a",1),("b",2)
      )
    )
  }
}