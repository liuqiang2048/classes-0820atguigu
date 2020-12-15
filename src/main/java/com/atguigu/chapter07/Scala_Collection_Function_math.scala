package com.atguigu.chapter07

import scala.collection.mutable

object Scala_Collection_Function_math{
  def main(args: Array[String]): Unit = {

    //TODO 1.集合--功能函数
    //TODO 2.map
    val list = List(1,2,3,4)
    val list1 = List("hello","spark","flume")

    def mapFunction (num: Int):Int={
      num * 2
    }

//    val newList = list.map(mapFunction)
//    val newList2 = list.map((num:Int)=>{num*2})
//    val newList3 = list.map((num:Int)=>num*2)
//    val newList4 = list.map((num)=>num*2)
//    val newList5 = list.map(num=>num*2)
    val newList = list.map(_*2)
    println(newList)
    println(list1.map(_.substring(0, 1).toUpperCase()))

    //todo 2.扁平化 --flatten
    //将整体拆分成一个一个的个体来使用的形式，称之为扁平化
    val list2 = List(List(1,2),List(3,4),List(5,6,7,8))

    val list3 = List(List(List(1,2)),
      List(List(3,4)),
      List(List(5,6,7,8)))

    //flatten只能拆除外层包装，如果集合是嵌套的，每一层多点一次flatten
    println(list2.flatten)
    println(list3.flatten.flatten)

    //练习一：需求  将下面字符数组拆分成一个个单词输出
    val list4 = List("hadoop hive spark","hive scala spark")
    println(list4.flatten) //(h, a, d, o, o, p,  , h, i, v, e,  , s, p, a, r, k, h, i, v, e,
    //scala 可以将字符串自动作为字符数组来使用

    //如果希望按照自定义规则数据扁平化，可以使用flatmap
    def flatMapFunction( s:String):Array[String]={
      s.split(" ")
    }

    println(list4.flatMap(flatMapFunction))




}

}
