package com.atguigu.spark.rdd.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark_RDD_Action_03 {
  def main(args: Array[String]): Unit = {

    //todo reduce的使用方法
val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
  val sc = new SparkContext(sparkConf)


    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),8)

    val i: Int = rdd.aggregate(0)(_+_,_+_)
    println(i)

    val i1 = rdd.aggregate(10)(_+_,_+_)
    println(i1)

    val rdd1: RDD[Int] = sc.makeRDD(List(1,2,3,4))
    val i2: Int = rdd1.fold(0)(_+_)
    println(i2)

    val rdd2: RDD[(Int, String)] = sc.makeRDD(List((1, "a"),
      (1, "a"), (1, "a"), (2, "b"), (3, "c"), (3, "c")))

    val intToLong: collection.Map[Int, Long] = rdd2.countByKey()

    println(intToLong)


    sc.stop()
  }
}
