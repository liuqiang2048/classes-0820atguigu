package com.atguigu.chapter05

/**
  * 下划线用法：
 * 1.将函数作为整体对象来使用
 * 2.代替匿名函数的参数
 */
object Scala06_Function_3 {
  def main(args: Array[String]): Unit = {

    def fun1(i : Int): Int ={
      i*2
    }

    def fun11()={
      fun1 _
    }
    println(fun11()(10))

   for(i <-1 to 5){

   }



  }
}