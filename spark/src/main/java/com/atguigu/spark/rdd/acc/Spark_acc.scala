package com.atguigu.spark.rdd.acc

import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

object Spark_acc {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster(
      "local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    //todo 1.声明累加器
    val sum: LongAccumulator = sc.longAccumulator("sum")

    //todo 2.使用累加器
    val rdd = sc.makeRDD(List(1,2,3,4),2)
  rdd.foreach(
   num=> {
      sum.add(num)
    }
  )
    //todo 3.获取结果
    println("sum:"+sum.value)


  }
}
