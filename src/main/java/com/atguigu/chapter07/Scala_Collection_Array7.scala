package com.atguigu.chapter07

object Scala_Collection_Array7 {
  def main(args: Array[String]): Unit = {

    //TODO 集合--功能方法
    //TODO 排序

    //将集合的每一条数据按照指定的规则进行排序
    val list= List(1,3,4,2)
    def sortFunction(num:Int):Int={

      //按照数字进行排序
      num
    }
    //sortBy 默认是进行升序排列（从小到大）
    println(list.sortBy(sortFunction))

    //sortBy  降序
    println(list.sortBy(sortFunction)(Ordering.Int.reverse))

    //拓展练习
    val list1 = List("1","2","11","22","3")

    println(list1.sortBy(s => s))
    println(list1.sortBy(s => s.toInt))


  }

}
