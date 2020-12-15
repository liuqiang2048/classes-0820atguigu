package com.atguigu.spark.rdd.practice

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_Practice {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster(
      "local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val datas: RDD[String] = sc.textFile("input/user_visit_action.txt")

    val clickData: RDD[(String, Int)] = datas.filter(
      line => {
        val dats = line.split("_")
        dats(6) != "-1"
      }
    ).map(
      line => {
        val dats = line.split("_")
        (dats(6), 1)

      }
    ).reduceByKey(_ + _)

    val orderdata: RDD[(String, Int)] = datas.filter(
      line => {
        val dats = line.split("_")
        dats(8) != "null"
      }
    ).flatMap(
      line => {
        val dats = line.split("_")
        val cs = dats(8).split(",")
        cs.map((_, 1))
      }
    ).reduceByKey(_ + _)


    val payData: RDD[(String, Int)] = datas.filter(
      line => {
        val dats = line.split("_")
        dats(10) != "null"
      }
    ).flatMap(
      line => {
        val dats = line.split("_")
        val cs = dats(10).split(",")
        cs.map((_, 1))
      }
    ).reduceByKey(_ + _)


    val cogroupRDD: RDD[(String, (Iterable[Int], Iterable[Int], Iterable[Int]))] =
      clickData.cogroup(orderdata, payData)

    val categoryData = cogroupRDD.map {
      case (category, (clickIter, orderIter, payIter)) => {

        var clickCnt = 0
        val clickIterator: Iterator[Int] = clickIter.iterator
        if (clickIterator.hasNext) {
          clickCnt = clickIterator.next()
        }

        var orderCnt = 0
        val orderIterator: Iterator[Int] = orderIter.iterator
        if (orderIterator.hasNext) {
          orderCnt = orderIterator.next()
        }

        var payCnt = 0
        val payIterator: Iterator[Int] = payIter.iterator
        if (payIterator.hasNext) {
          payCnt = payIterator.next()
        }

        (category, (clickCnt, orderCnt, payCnt))
      }
    }

    categoryData.sortBy(_._2,
      false).take(10).foreach(println)


  }
}








