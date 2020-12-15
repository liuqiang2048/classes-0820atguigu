package com.atguigu.chapter07

import scala.collection.mutable

object Practice_3 {
  def main(args: Array[String]): Unit = {
 val list = List(1,2,3,4)

        //TODO 常用方法
    //1.集合长度
    println(list.size)
    println(list.length)

    //2.判断是否为空
    println(list.take(2))
    println(list.isEmpty)

    //3.集合迭代器
    println(list.iterator)

    //4.循环遍历数组
    list.foreach(println)

    //5.将集合转换成字符串
    println(list.mkString(", "))

    //.6.判断集合中是否包含某个元素
    println(list.contains(2))

    //7.取集合前几个元素
    println(list.take(2))

    //8取集合的后几个元素
    println(list.takeRight(2))

    //9.查找元素
    println(list.find(x => x % 2 != 0))

    //10 丢弃前几个元素
    println(list.drop(2))

    //10.丢弃后几个元素
    println(list.dropRight(2))

    //11.反转集合
    println(list.reverse)

    //12.去重
    println(list.distinct)


  }
}