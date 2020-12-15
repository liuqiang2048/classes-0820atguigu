package com.atguigu.chapter05

object Scala02_Function {
def main(args: Array[String]): Unit = {

  //函数式编程的基本语法
  //函数声明
  // def 函数名（参数列表 ） ： 函数返回值类型
  //函数&方法
  //方法就是函数
  //java没有函数的概念 有方法的概念
  //scala
  //类中声明的函数称之为方法，其他地方声明的就是函数
  //因为方法声明在类中，所以要符合方法的约束和规则
  //

  val f = () => {
    println("zhangsan")
  }
  f()

}
}
