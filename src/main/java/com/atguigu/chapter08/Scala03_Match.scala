package com.atguigu.chapter08

object Scala03_Match {
  def main(args: Array[String]): Unit = {


    //TODO 模式匹配
    // 1.--匹配数组

    //应用场景
    val t = (1,"zhangsan",30)
    val (id,name ,age) = (1,"zhangsan",30)

    println(id)
    println(name)
    println(age)

    val map = Map(("a",1),("b",2),("c",3))

    for ((k,2)<-map){
      println(k)
    }

  }
}
