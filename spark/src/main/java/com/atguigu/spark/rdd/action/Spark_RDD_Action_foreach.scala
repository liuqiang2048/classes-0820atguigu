package com.atguigu.spark.rdd.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark_RDD_Action_foreach {
  def main(args: Array[String]): Unit = {

  val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
  val sc = new SparkContext(sparkConf)


    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
    rdd.map(num=>num).collect().foreach(println)
    println("***********")

    rdd.foreach(println)

    rdd.saveAsTextFile("output")
    rdd.saveAsTextFile("output1")
    rdd.map((_,1)).saveAsSequenceFile("output2")


    sc.stop()
  }
}
