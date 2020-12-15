package com.atguigu.spark.rdd.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount10 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster(
      "local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val fileRDD: RDD[String] = sc.textFile("input/word.txt")

    val rddend = fileRDD.flatMap(_.split(" ")).map((_, 1)).combineByKey(
      x => x,
      (x: Int, y: Int) => (x + y),
      (m: Int, n: Int) => (m + n)
    )
    rddend

    rddend.foreach(println)



  }

}
