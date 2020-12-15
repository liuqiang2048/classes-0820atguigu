package com.atguigu.chapter05

object Scala04_Function {
def main(args: Array[String]): Unit = {

  //TODO 函数的参数有多少个？
  //无线多
  //将函数给其他人的使用，这个时候参数个数有限制，不能多余22个

  def fun1 (names:String*): Unit ={
    println(names)
  }
  fun1()
  fun1("zhangsan")
  fun1("zhansgan","lisi")

  //2参数默认值
  def fun2(name:String,passwd:String="000000"): Unit ={
    println(name+" "+ passwd)
  }
  fun2("zhanssan")//如果没有写 会自动打印默认值，
  // 如果参入新的参数，将会把默认值替代
  fun2("123456","zhangsan")

  //可以省略return关键字
  def fun3(): String ={
    return "zhangsan"
  }
  def fun4(): String ={
    "zhangsan"
  }

  //省略花括号  --执行方法体的花括号可以直接省略
  def fun5(): String = "zhangsan"

  //省略返回值类型
  def fun6 () = "zhangsan"

  //省略参数列表
  def fun7 = " zhangsan"

  //省略等号





}
}
