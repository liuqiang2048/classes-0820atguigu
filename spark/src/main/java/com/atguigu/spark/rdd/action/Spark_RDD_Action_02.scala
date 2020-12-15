package com.atguigu.spark.rdd.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark_RDD_Action_02 {
  def main(args: Array[String]): Unit = {

    //todo reduce的使用方法
val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
  val sc = new SparkContext(sparkConf)

    val rdd: RDD[Int] = sc.makeRDD(List(1,5,2,3,4))
    //    rdd.collect().foreach(println)
        val countResult: Long = rdd.count()
    println(countResult)

    val firstResult: Int = rdd.first()
    println(firstResult)

    val takeResult = rdd.take(2)
    println(takeResult.mkString(","))

    val results: Array[Int] = rdd.takeOrdered(2)
    println(results.mkString("--"))


  }
}
