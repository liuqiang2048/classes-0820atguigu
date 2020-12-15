package com.atguigu.spark.rdd.wordcount

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import scala.collection.mutable

object wordCount10liqibo {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    sc.setCheckpointDir("output")
    val lines: RDD[String] = sc.textFile("d:/word1.txt")
    val words: RDD[String] = lines.flatMap(_.split(" "))
    words.cache()
    words.checkpoint()
    //1 reduceByKey
    val wordToOne: RDD[(String, Int)] = words.map((_, 1))
    val wordCount1: RDD[(String, Int)] = wordToOne.reduceByKey(_ + _)
    wordCount1.collect().foreach(println)
    print("1111111111111111111111")
    val wordToOne2: RDD[(String, Int)] = words.map((_, 1))
    val wordCount2: RDD[(String, Int)] = wordToOne2.aggregateByKey(0)(_ + _, _ + _)
    wordCount2.collect().foreach(println(_))
    println("222222222222222222222")
    val wordToOne3: RDD[(String, Int)] = words.map((_, 1))
    val wordCount3: RDD[(String, Int)] = wordToOne3.foldByKey(0)(_ + _)
    wordCount3.collect().foreach(println(_))
    println("33333333333333333333333")
    val wordToOne4: RDD[(String, Int)] = words.map((_, 1))
    val wordCount4: collection.Map[String, Long] = wordToOne4.countByKey()
    println(wordCount4)
    println("4444444444444444")
    val wordCount5: collection.Map[String, Long] = words.countByValue()
    println(wordCount5)
    println("555555555555555")
    val wordToMap: RDD[(String, Iterable[String])] = words.groupBy(word => word)
    val wordCount6: RDD[(String, Int)] = wordToMap.mapValues(_.size)
    wordCount6.collect().foreach(println)
    print("6666666666666666")
    val wordToOne5: RDD[(String, Int)] = words.map((_, 1))
    val wordToList: RDD[(String, Iterable[Int])] = wordToOne5.groupByKey()
    val wordCount7: RDD[(String, Int)] = wordToList.mapValues(_.size)
    wordCount7.collect().foreach(println(_))
    println("777777777777")
    val wordToOne6: RDD[(String, Int)] = words.map((_, 1))
    val wordCount8: RDD[(String, Int)] = wordToOne6.combineByKey((num: Int) => num, (x: Int, y: Int) => x + y, (x: Int, y: Int) => x + y)
    wordCount8.collect().foreach(println)
    println("88888888888888")

    val wordCount9: Map[String, Int] = words.map(word => Map[String, Int]((word, 1))).fold(Map[String, Int]())(
      (map1, map2) => {
        map1.foldLeft(map2)(
          (map, kv) => {
            val word = kv._1
            val count = kv._2
            map.updated(word, map.getOrElse(word, 0) + count)
          }
        )
      })
    println(wordCount9)
    println("9999999999999")

    val wordCount10: Map[String, Int] = words.aggregate(Map[String, Int]())(
      (map, k) => {
        map.updated(k, map.getOrElse(k, 0) + 1)
      },
      (map1, map2) => {
        map1.foldLeft(map2)(
          (map, kv) => {
            val word = kv._1
            val count = kv._2
            map.updated(word, map.getOrElse(word, 0) + count)
          })
      })
    println(wordCount10)
    println("1010101010101001010")
  }
}
