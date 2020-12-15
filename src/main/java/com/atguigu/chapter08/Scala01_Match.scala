package com.atguigu.chapter08

object Scala01_Match {
  def main(args: Array[String]): Unit = {

    //TODO 模式匹配
    //java ：switch多重

    //模式匹配语法没有break操作，执行完毕后，直接退出
    //模式匹配主要目的：将数据进行规则匹配，必须匹配上

    var a: Int = 10
    var b: Int = 20
    var operator: Char = 'd'
    var result = operator match {
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case '/' => a / b
      case _ => "illegal"  //类似于default，上面“case”
        //    外的所有的值，且只能在尾部，不能放在首行
    }
    println(result)
  }
}
