package com.atguigu.spark.rdd.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark_RDD_Action_01 {
  def main(args: Array[String]): Unit = {

    //todo reduce的使用方法
val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
  val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))

    val reduceResult: Int = rdd.reduce(_+_)
    println(reduceResult)
  }
}
