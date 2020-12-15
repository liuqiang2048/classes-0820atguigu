package com.atguigu.chapter08

object Scala02_Match {
  def main(args: Array[String]): Unit = {


    //TODO 模式匹配
    // 1.--匹配常量
    def describe(x: Any) = x match {
      case 5 => "Int five"
      case "hello" => "String hello"
      case true => "Boolean true"
      case '+' => "Char +"
    }


    // TODO 2.--匹配常量

    def describe1(x: Any) = x match {
      case i: Int => "Int"
      case s: String => "String hello"
      case m: List[_] => "List"
      case c: Array[Int] => "Array[Int]"
      case someThing => "something else " + someThing
    }
  }
}
