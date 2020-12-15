package com.atguigu.chapter05

/**
 *
 */
object Scala08_Function {
  def main(args: Array[String]): Unit = {

    //函数到底是什么
    //1.函数
    //    编译时：会编译为private static final方法，

    //2.方法
    //     编译时：会编译微博java中成员方法

    def test(): Unit =
{
  println("test1..")
}
  }

  def test(): Unit ={
    println("test2..")
  }
}