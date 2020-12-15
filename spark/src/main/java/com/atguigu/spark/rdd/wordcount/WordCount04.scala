package com.atguigu.spark.rdd.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount04 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster(
      "local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val fileRDD: RDD[String] = sc.textFile("input/word.txt")
    val rddend = fileRDD.map((_, 1)).map(kv => {
      Map[String, Int](kv)
    }).reduce((map1, map2) => {
      map1.foldLeft(map2)((map, kv) => {
        val k = kv._1
        val v = kv._2
        val newValue = map.getOrElse(k, 0) + v
        map.updated(k, newValue)
      })
    })
    rddend.foreach(println)



  }

}
