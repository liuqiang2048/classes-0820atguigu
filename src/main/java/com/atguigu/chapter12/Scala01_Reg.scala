package com.atguigu.chapter12

import scala.util.matching.Regex

object Scala01_Reg {
  def main(args: Array[String]): Unit = {

    //todo :正则表达式


    //todo :声明正则表达式
    val r1 : Regex = "a".r //字符串中有没有指定子字符串
    val r2 : Regex = "^a".r

    //todo :匹配字符串
    val maybeString = r1.findFirstIn("hello")
    if (maybeString.isEmpty){
      println("未匹配到字符串内的数据")
    }else{
      println("匹配到字符串内的数据"+maybeString.get)
    }

  }
}