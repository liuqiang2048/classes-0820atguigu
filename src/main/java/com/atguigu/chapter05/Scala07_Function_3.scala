package com.atguigu.chapter05

/**
 * TODO 递归函数
 * 1.函数内部调用自身
 * 2.函数应该存在跳出递归时的逻辑
 * 3.函数在传递参数时应该有规律
 * 4.递归函数必须，明确声明返回值类型，不能省略
 * 4.
 */
object Scala07_Function_3 {
  def main(args: Array[String]): Unit = {


    test(5)
    def test(num :Int): Int ={
      if (num <=1){
        1
      }
      else {
        num * test(num -1)
      }
    }


  //尾（伪）递归
    //scala 编译器在编译时会讲尾递归代码便以为while死循环
    //java有尾递归，没有优化，所以依然会出错
    test1()

    def test1(): Unit ={
      println("1111")  //如果放在test1()下面 就成了真的递归，会报StackOverflowError异常
      test1()
    }


  }
}