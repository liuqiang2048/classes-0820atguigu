package com.atguigu.chapter07

import scala.collection.mutable

object Scala_Collection_map{
  def main(args: Array[String]): Unit = {

    //TODO 集合--映射（转换）Map
    //map中存储的是键值对数据： k-v
    //无序，key不能重复，但是v可以重复
    //默认情况下，scala提供的map集合也是不可变的
    //书写：键值对：k->v

    val map = Map("a"->1, "b"->2,"c"->3,"d"->4,"e"->5)

    //可变map集合
    val map1 = mutable.Map("a"->1,"b"->2,"c"->3)

    println(map1)

    //修改数据基本操作
    //增加数据
    map1.put("d",4)
    //更新
    map1.update("b",8)
    //获取
    map1.get("c")
    //删除
    map1.remove("d")

    //遍历
    println(map1.mkString(","))
    map1.foreach(println)



}

}
