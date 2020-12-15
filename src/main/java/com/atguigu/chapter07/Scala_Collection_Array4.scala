package com.atguigu.chapter07

object Scala_Collection_Array4 {
  def main(args: Array[String]): Unit = {

    //TODO 集合--功能方法
    //TODO 扁平化


    //将整体拆分成一个一个的个体来使用的方式，称之为扁平化
    //flatten只能拆除外层结构，想要拆除再里面一层，需要再flatten一次

    val list = List(
      List(1,2),List(3,4),List(5,6,7,8)
    )

    println(list.flatten)
}

}
