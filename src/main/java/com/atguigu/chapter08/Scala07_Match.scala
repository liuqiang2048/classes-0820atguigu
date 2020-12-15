package com.atguigu.chapter08

object Scala07_Match {
  def main(args: Array[String]): Unit = {


    //TODO 模式匹配 --应用场景
    val t = (1,"zhangsan",30)
    val (id,name,age) = (1,"zhangsan",30)
    //普通写法
    println(t._1)
    println(t._2)
    println(t._3)
    //使用模式匹配
    println(id)
    println(name)
    println(age)

    //练习一
    val map = Map(("a",1),("b",2),("c",3))
    for (kv<-map){
      println(kv._1+"="+kv._2)
    }

    for ((k,2)<-map){
      println(k)
    }


  }
}
