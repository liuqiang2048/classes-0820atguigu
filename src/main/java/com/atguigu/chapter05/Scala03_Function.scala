package com.atguigu.chapter05

object Scala03_Function {
def main(args: Array[String]): Unit = {
      //函数的基本使用方式和声明方式
      //对于函数式编程  什么最重要 ？  IO
    //六种
    //TODO 1.无参  无返回值
  def fun1(): Unit ={
        println("funl...")
      }
  fun1()
  fun1   //如果参数列表没有参数，调用时可以省略小括号

  //TODO 2. 有参  无返回值
  def fun2(name :String): Unit ={
    println("name +"+name)
  }

  fun2("zhangsan")

  //TODO 3.无参 有返回值
  def fun3(): String ={
    "zhangsan"
  }
  println(fun3())

  //4有参 有返回值
  def fun4(name:String): String ={
    "Hello" +name

  }

  println(fun4("huangfeihong"))

  //TODO  5.多参  无返回值

  def fun5 (name :String , passwd :String): Unit ={
    println(name + ""+ passwd)
  }
  fun5("wangming"," 123456")

  //TODO 6.多参 有返回值
  def fun6(age:Int,tall:Int): String ={
    age + " " +tall
  }
  println(fun6(18,180))



    //


}
}
