package com.atguigu.spark.rdd.wordcount

import org.apache.spark.{SparkConf, SparkContext}

object WordCount01 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster(
      "local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    sc.textFile("input/word.txt")
      .flatMap(_.split(" "))
      .map((_,1))
      .reduceByKey(_+_)
      .collect()
      .foreach(println)
      sc.stop()
  }

}
