package com.atguigu.chapter07

object Scala_Collection_Array {
  def main(args: Array[String]): Unit = {

    //TODO 集合--数组
    //创建

    val array:Array[String] = new Array[String](3)
    //scala中的中括号有特殊含义，所以不能作为索引进行范围表
    //应该使用小括号
    array(0) = "zhangsan"

    //打印
    println(array(0))

}

}
