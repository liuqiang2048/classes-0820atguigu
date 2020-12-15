package com.atguigu.chapter05

object Scala05_Function {
def main(args: Array[String]): Unit = {

  //TODO 可变参数  使用星号表示   来解决参数类型相同，个数不同，
  // 不确定带来的问题
  def fun1(names :String*): Unit ={
    println(names)
  }
    fun1()
  fun1("zhansgan")
  fun1("lisi")


  //1.2可变参数需要放置在参数列表的最后

}
}
