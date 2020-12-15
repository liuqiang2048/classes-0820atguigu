package com.atguigu.spark.rdd.acc

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

object Spark03_acc_wordcount {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster(
      "local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val rdd1 = sc.makeRDD(
      List(
        ("a",1),("b",2)
      )
    )
    val map = Map(

        ("a",3),("b",4)
      )


    // todo 1.创建广播变量
    val bc: Broadcast[Map[String, Int]] = sc.broadcast( map)

    //todo
    val rdd3 = rdd1.map{
      case (k,v)=>{

        //todo 2.使用广播变量
        (k,(v,bc.value.getOrElse(k,0)))
      }
    }
    println(rdd3.collect().mkString(","))
    sc.stop()
  }
}
