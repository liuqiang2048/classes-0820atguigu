package com.atguigu.chapter05

import scala.util.control.Breaks

object Practice_1 {
  def main(args: Array[String]): Unit = {

    //函数作为值//    def fun1(): String ={
    //      "zhangsan"
    //    }
    //    val a = fun1
    //    val b = fun1 _
    //
    //    println(a)
    //    println(b)

    //2.函数作为参数
//    def fun2(i: Int): Int ={
//        i*2
//    }
//
//    def fun22 (f:Int=>Int): Int ={
//      f(10)
//    }
//    println(fun22(fun2))

    //3.函数作为返回值
//    def fun3 (i:Int):Int={
//      i*2
//    }
//
//    def fun33()={
//      fun3 _
//    }
//    println(fun33()(10))

    //4.匿名函数
//    () => {
//      println("88888")
//    }
//      //本身自己无法完成调用，需要赋值交给一个变量
//      val f= ()=>{
//        println("477777")
//      }
//      f()

//        def fun4( f:Int => Int ): Int = {
//          f(10)
//        }
//        println(fun4((x:Int)=>{x * 20}))
//        println(fun4((x)=>{x * 20}))
//        println(fun4((x)=>x * 20))
//        println(fun4(x=>x * 20))
//        println(fun4(_ * 20))

        //函数柯里化

  }
}