package com.atguigu.spark.rdd.practice

import com.atguigu.spark.rdd.framework.controller.WordountController
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark02_Practice_acc {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster(
      "local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val datardd1: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("a",2),("c",3)))

    val datardd2: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("c",2),("c",3)))

    val value: RDD[(String, (Iterable[Int], Iterable[Int]))] =
      datardd1.cogroup(datardd2)

    value.collect().foreach(println)
  }
}








