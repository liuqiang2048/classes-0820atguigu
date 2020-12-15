package com.atguigu.spark.rdd.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount02 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster(
      "local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val rdd1: RDD[String] = sc.textFile("input/word.txt")
    val rddend: RDD[(String, Int)] = rdd1.flatMap(_.split(" ")).map((_, 1)).groupByKey().map(elem => {
      (elem._1, elem._2.sum)
    })
    rddend.collect().foreach(println)

  }
}