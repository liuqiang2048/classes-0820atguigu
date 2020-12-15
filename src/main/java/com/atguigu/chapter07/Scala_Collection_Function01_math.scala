package com.atguigu.chapter07

object Scala_Collection_Function01_math{
  def main(args: Array[String]): Unit = {

    //TODO 1.集合--功能函数
    //TODO 3.过滤
    val list = List(1,2,3,4)
     //filter方法可以按照指定的规则对数据进行筛选过滤
    //每一条数据会进行处理，如果处理的结果为true,数据保存，如果数据结果为false,数据丢弃
    def filterFunction (num:Int):Boolean={
      num%2 !=0
    }
//    list.filter(filterFunction)
    println(list.filter(_ % 2 != 0))

    //todo 练习一
    //需求：过滤出小写字母“s”开头的字符串
    val list1 = List("hadoop","hive","spark","scala")
    println(list1.filter(_.startsWith("s")))
}

}
