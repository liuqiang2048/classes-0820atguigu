package com.atguigu.spark.rdd.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount06 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster(
      "local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val fileRDD: RDD[String] = sc.textFile("input/word.txt")

    val rddend = fileRDD.map((_, 1)).aggregate(Map[String, Int]())((map1, kv) => {
      val k: String = kv._1
      val v: Int = kv._2
      val newValue = map1.getOrElse(k, 0) + v
      map1.updated(k, newValue)
    }, ((map1, map2) => {
      map1.foldLeft(map2)((map, kv) => {
        val k: String = kv._1
        val v: Int = kv._2
        val newValue = map.getOrElse(k, 0) + v
        map.updated(k, newValue)
      })
    }))

    rddend.foreach(println)

    sc.stop()

  }

}
