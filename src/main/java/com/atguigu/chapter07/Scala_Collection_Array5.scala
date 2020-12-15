package com.atguigu.chapter07

object Scala_Collection_Array5 {
  def main(args: Array[String]): Unit = {

    //TODO 集合--功能方法
    //TODO 扁平化

//  val list = List(
//    "hadoop  haive spark")
//    //scala可以将字符串自动作为字符数组来使用
//   println(list.flatten)
//  //如果希望按照自定义的规则进行数据的扁平化，可以使用flatMap
//
//    def flatMapFuncyion (s:String):Array[String] ={
//    s.split("")
//    }
//
//    list.flatMap(flatMapFuncyion)

    //TODO 集合--功能方法
    //TODO 过滤

    val list = List(1,2,3,4)
//filter方法可以按照指定的规则对数据记性帅选过滤

    def filterFunction(num :Int):Boolean={
      num % 2 !=0
    }

    //println(list.filter(filterFunction))
    println(list.filter(_ % 2 != 0))

    //test1
    val list1 = List()

}

}
