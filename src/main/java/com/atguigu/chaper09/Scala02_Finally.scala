package com.atguigu.chaper09

import scala.collection.mutable

object Scala02_Finally {
  def main(args: Array[String]): Unit = {

    //TODO Scala异常不分类
    //  finally
    //
    //      try {
    //        var n= 10 / 0
    //      }catch {
    //        case ex: ArithmeticException=>{
    //          // 发生算术异常
    //          println("发生算术异常")
    //        }
    //        case ex: Exception=>{
    //          // 对异常处理
    //          println("发生了异常1")
    //        }
    //      }finally {
    //        println("finally")
    //      }
    //    }
    //    val name : String = "scala"
    //    val subname : String = name.substring(0,2)
    //      // 字符串连接
    //      println("Hello " + name)
    //    println("name= %s\n",name)
    //    }
    val map1 = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    val map2 = mutable.Map("d" -> 4, "e" -> 5, "f" -> 6)
    map1.put("d", 4)
    val map3: mutable.Map[String, Int] = map1 + ("e" -> 4)
    println(map1 eq map3)
    val map4: mutable.Map[String, Int] = map1 += ("e" -> 5)
    println(map1 eq map4)

    //  class Student{
    //     //如果想要scala方法抛出异常，需要增加注解
    //    @throw (classOf[Exception])
    //    def test(): Unit ={
    //      throw new  Exception
    //    }

  }
}