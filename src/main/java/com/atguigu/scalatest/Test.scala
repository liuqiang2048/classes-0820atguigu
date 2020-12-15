package com.atguigu.scalatest

object Test {
  def main(args: Array[String]): Unit = {

    for ( i <- Range(1,5) ) { // 范围集合
      println("i = " + i )
    }
    for ( i <- 1 to 5 ) { // 包含5
      println("i = " + i )
    }
    for ( i <- 1 until 5 ) { // 不包含5
      println("i = " + i )
    }
}

}
