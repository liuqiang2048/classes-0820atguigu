//package com.atguigu.spark.rdd.acc
//
//import org.apache.commons.lang.mutable.Mutable
//import org.apache.spark.util.{AccumulatorV2, LongAccumulator}
//import org.apache.spark.{SparkConf, SparkContext}
//
//import scala.collection.mutable
//
//object Spark01_acc_wordcount {
//  def main(args: Array[String]): Unit = {
//
//    val sparkConf = new SparkConf().setMaster(
//      "local[*]").setAppName("WordCount")
//    val sc = new SparkContext(sparkConf)
//
//    val rdd = sc.makeRDD(List(
//      ("a", 1), ("a", 2), ("a", 3), ("b", 1), ("b", 2)))
//    rdd
//
//    //todo 1.创建累加器
//    val acc = new  WordcounTaccountlator
//
//    //todo 2.向Spark进行注册
//    sc.register(acc,"WordCount")
//
//    //todo 3.向累加器中增加数据
//    rdd.foreach(
//      kv=>{
//        acc.add(kv)
//      }
//    )
//
//    //todo 4.获取累加器的累加结果
//    println(acc.value)
//
//    sc.stop()
//  }
//  // 自定义累加器
//  //1.继承AccumulatorV2
//  //2.自定义泛型【In,Out】
//  //in:(Sting,Int)定义将什么类型的数据增加到累加器中
//  //out:mutable .Map[string,int]
//  //3.重写抽象方法
//
//  class  WordcounTaccountlator extends AccumulatorV2
//    [(String,Int),mutable.Map[String,Int]] {
//
//    val wcmap: mutable.Map[String, Int] = mutable.Map[String,Int]()
//
//    override def isZero: Boolean = {
//      wcmap.isEmpty
//    }
//
//    override def copy(): AccumulatorV2[(String, Int), mutable.Map[String, Int]] = {
//      new WordcounTaccountlator()
//    }
//
//    override def reset(): Unit = {
//      wcmap.clear()
//    }
//
//    //todo 向累加器中增加数据
//    override def add(t: (String, Int)): Unit = {
//      val k = t._1
//      val v = t._2
//      wcmap.update(k,wcmap.getOrElse(k,0)+v)
//    }
//    //todo 合并多个累加器的值
//    override def merge(other: AccumulatorV2[(String, Int), mutable.Map[String, Int]]): Unit = {
//      val map1 = this.wcmap
//      val map2 = other.value
//
//      this.wcmap = map1.foldLeft(map2) {
//        case (m, (k, v)) => {
//          m.updated(k, m.getOrElse(k, 0) + v)
//        }
//      }
//
//    }
//      //todo 返回累加器的计算结果
//    override def value: mutable.Map[String, Int] = {
//      wcmap
//    }
//  }
//}
