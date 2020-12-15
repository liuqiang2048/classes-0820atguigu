package com.atguigu.day01

object ScalaString {
  def main(args: Array[String]): Unit = {
  val name : String = "scala"
    //1.字符串的连接
    println("Hello " + name)

    //2传值字符串
     println("name=%s\n",name)

    //3.插值字符串
    println(s"name=${name}")

    //4.多行字符串
    println(
      s"""
         | Hello
         | ${name}
        """.stripMargin)
  }


}
