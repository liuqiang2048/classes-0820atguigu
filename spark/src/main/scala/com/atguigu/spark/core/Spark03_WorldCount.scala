package com.atguigu.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark03_WorldCount {
  def main(args: Array[String]): Unit = {

    //TODO Spark - WouldCount
    //Spark 是一个计算框架
    //开发人员是使用Spark框架的API实现计算功能

    //TODO 1.准备Spark环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")

    //TODO 2.建立和Spark的连接
    val sc = new SparkContext(sparkConf)

    //TODO 3.读取文件中的数据
    val fileRDD: RDD[String] = sc .textFile("input/word.txt")

    //TODO 4.将一行一行的字符串数据拆分成一个一个的单词
    val wordRDD: RDD[String] = fileRDD.flatMap(_.split(" "))

    //TODO 5.将相同的单词分在一个组中
    val word2OneRDD: RDD[(String, Int)] = wordRDD.map((_,1))

    //TODO 6.将分组后的数据进行结构转化
    val word2CountRDD: RDD[(String, Int)] = word2OneRDD.reduceByKey(_+_)

    //TODO 7.将相同的单词分在一个组中
    val word2Count = word2CountRDD.collect()

    //TODO 8.打印结果
    word2Count.foreach(println)

    //TODO 8.释放连接
    sc.stop()
  }
}
