package com.atguigu.chapter07

object Scala_Collection_Array6 {
  def main(args: Array[String]): Unit = {

    //TODO 集合--功能方法
    //TODO 分组

    //按照指定的分组规则数据放在一起
    val list = List(1,2,3,4)

    def groupFunction(num : Int):Int= {
      num % 2

    }

    println(list.groupBy(groupFunction))
  }

}
