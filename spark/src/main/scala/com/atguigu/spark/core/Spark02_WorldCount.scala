package com.atguigu.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark02_WorldCount {
  def main(args: Array[String]): Unit = {

    //TODO Spark - WouldCount
    //Spark 是一个计算框架
    //开发人员是使用Spark框架的API实现计算功能


    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")

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
