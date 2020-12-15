package com.atguigu.spark.rdd.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount07 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster(
      "local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val fileRDD: RDD[String] = sc.textFile("input/word.txt")

    val rddend: RDD[(String, Int)] = fileRDD.flatMap(_.split(" ")).map((_, 1))
      .aggregateByKey(0)(_ + _, _ + _)


    rddend.foreach(println)



  }

}
