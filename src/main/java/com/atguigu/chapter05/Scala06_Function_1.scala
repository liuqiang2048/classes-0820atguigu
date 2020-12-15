package com.atguigu.chapter05

/**
  * 下划线用法：
 * 1.将函数作为整体对象来使用
 * 2.代替匿名函数的参数
 */
object Scala06_Function_1 {
def main(args: Array[String]): Unit = {



//  def fun1(): Unit ={
//    println("scala...")
////  }
//
//  val f1 = fun1 _ //不加括号  f1以为是函数的unit结果  ，
//                  // 并不是以对象发过去的
//  f1()

  //价格函数作为值
  def fun2(): String ={
    "zhangsan"
  }
  val a = fun2
  //val b = fun _
  println(a)
 // println(b)


} 
}
