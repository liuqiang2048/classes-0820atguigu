package com.atguigu.chapter08

object Scala06_Match {
  def main(args: Array[String]): Unit = {


    //TODO 模式匹配
    // 1.--匹配对象
//
//   val map = Map(("A",1),("B",2),("C",3))
//
//    for (kv<-map){
//      println(kv._1+","+kv._2)
//    }


    //并行
//    val result1 = (0 to 100).map{x => Thread.currentThread.getName}
//    val result2 = (0 to 100).par.map{x => Thread.currentThread.getName}
//
//    println(result1)
//    println(result2)
def describe(x: Any) = x match {
  case 5 => "Int five"
  case "hello" => "String hello"
  case true => "Boolean true"
  case '+' => "Char +"
}
//    println(describe('+'))

    var a: Int = 10
    var b: Int = 20
    var operator: Char = 'd'
    var result = operator match {
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case '/' => a / b
      case _ => "illegal"
    }
//    println(result)

    def describe1(x: Any) = x match {
      case i: Int => "Int"
      case s: String => "String hello"
      case m: List[_] => "List"
      case c: Array[Int] => "Array[Int]"
      case someThing => "something else " + someThing
    }
//    println(describe1(List(1)))

    for (arr <- Array(Array(0),
      Array(1, 0),
      Array(0, 1, 0),
      Array(1, 1, 0),
      Array(1, 1, 0, 1),
      Array("hello", 90))) { // 对一个数组集合进行遍历
      val result = arr match {
        case Array(0) => "0" //匹配Array(0) 这个数组
        case Array(x, y) => x + "," + y //匹配有两个元素的数组，然后将将元素值赋给对应的x,y
        case Array(0, _*) => "以0开头的数组" //匹配以0开头和数组
        case _ => "something else"
      }
//      println("result = " + result)
    }

    for (list <- Array(
      List(0),
      List(1, 0),
      List(0, 0, 0),
      List(1, 0, 0),
      List(88))) {
      val result = list match {
        case List(0) => "0" //匹配List(0)
        case List(x, y) => x + "," + y //匹配有两个元素的List
        case List(0, _*) => "0 ..."
        case _ => "something else"
      }

      println(result)
    }

    val list: List[Int] = List(1, 2, 5, 6, 7)

    list match {
      case first :: second :: rest => println(first + "-" + second + "-" + rest)
      case _ => println("something else")
    }
  }
}
