package com.atguigu.chapter07

object Scala_Collection_Function02_math{
  def main(args: Array[String]): Unit = {

    //TODO 1.集合--功能函数
    //TODO 4.分组
    //按照指定的分组规则将数据放在一起。
    val list = List(1,2,3,4)

    def groupFunction (num : Int):Int={
      num %2
    }
    //分组后，返回的结果为  map类型
    //K：分组key
    //V: 符合分组key的数据集合
    println(list.groupBy(_ % 2))    //Map(1 -> List(1, 3), 0 -> List(2, 4))

    //TODO 练习一：
    val list1 = List("hadoop","hive","scala","spark")
    println(list1.groupBy(_.substring(0, 1)))   //Map(h -> List(hadoop, hive), s -> List(scala, spark))


}

}
