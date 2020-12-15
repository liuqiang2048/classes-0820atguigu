package com.atguigu.day01

object ScalaIn {
def main(args: Array[String]): Unit = {

  val age :  Int = scala.io.StdIn.readInt()
  println(age)

    scala.io.Source.fromFile("").foreach(
      line => {
        print(line)
      }
    )
  scala.io.Source.fromFile("").getLines()

}
}
