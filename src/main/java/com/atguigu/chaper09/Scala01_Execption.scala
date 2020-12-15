package com.atguigu.chaper09

object Scala01_Execption {
  def main(args: Array[String]): Unit = {

    //TODO Scala异常不分类
    //scala中没有throws关键字
    //scala中异常的处理类似于模式匹配
    //如果异常类型没有匹配成功，也不会发生MathEerror,只是将异常抛给JVM
    try{
      val i = 0
      val j = 10/i
    }catch {
      case  e : ArithmeticException =>println("算数异常")
//      case  e : Exception =>println("其他异常")
    }finally {

    }

  }
}
