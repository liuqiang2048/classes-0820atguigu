package com.atguigu.chapter05

/**
  * 下划线用法：
 * 1.将函数作为整体对象来使用
 * 2.代替匿名函数的参数
 */
object Scala06_Function_2 {
  def main(args: Array[String]): Unit = {

   def fun1(i : Int): Int ={
      i * 2
   }
    def fun11(f : Int => Int): Int ={
      f(10)
    }
    println(fun11(fun1))

    //函数作为返回值
    def fun2(i : Int): Int ={
    i *3
    }
    def fun22() = {
      fun2 _
    }
    println(fun22()(10))

    //匿名函数
    def fun3 (f : Int => Int): Unit ={
      f(10)
    }

    println(fun3((x:Int)=>{x *20}))
    println(fun3((x)=>{x*20}))
    println(fun3((x)=>x*20))
    println(fun3(x=>x*20))
    println(fun3(_*20))
  }
}