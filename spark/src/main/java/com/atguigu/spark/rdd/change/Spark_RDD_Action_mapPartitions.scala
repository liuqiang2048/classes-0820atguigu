package com.atguigu.spark.rdd.change

import org.apache.spark.{SparkConf, SparkContext}

object Spark_RDD_Action_mapPartitions {
  def main(args: Array[String]): Unit = {

  val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
  val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1,2,3,4))


    sc.stop()
  }
}
