package com.atguigu.chapter07

object Scala_Collection_Function03_math{
  def main(args: Array[String]): Unit = {

    //TODO 1.集合--功能函数
    //TODO 5.排序

    //将集合的每一条数据按照指定的规则进行排序
    val list= List(1,3,2,4)

    def sortFunction (num :Int): Int ={
      //按照数字来排序
      num
    }
    //sortBy默认的排序为升序（从小到大）
    println(list.sortBy(sortFunction))  //List(1, 2, 3, 4)

    //sortBy更改排序为降序（从大到小）
    println(list.sortBy(sortFunction)(Ordering.Int.reverse))  //List(4, 3, 2, 1)

    //TODO 练习一
    val list1 = List("1","2","11","22","23","3")

    //字符串的排序方式默认是按照字典顺序
    println(list1.sortBy(s => s)) //List(1, 11, 2, 22, 23, 3)
    //按照数字来排，转成int
    println(list1.sortBy(s => s.toInt)) //List(1, 2, 3, 11, 22, 23)


  }

}

