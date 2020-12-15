package com.atguigu.day01

/**
 * scala各个变量的定义
 */
object HelloScala {

  def main(args: Array[String]): Unit = {
    System.out.println("Hello Scala")
    print("Hello Scala")

    //1.变量声明的完整格式：
    //  var/val  变量名 ： 变量类型 = “变量值”；
    var username : String = "zhansgan"

    val userpassword : String = "00000"
    //2.可以省略变量名
    var myname = "lisi"

    //3.变量初始化 必须显示赋值
    //var name1  错误写法
    var name2 = "lisi"  //正确

    //4.可变变量
    var name3 : String = "zhangming"
    name3 = "zg"
    //name3 = ture 错误写法

    val name4 : String = "zhangsan"
    //name4 = "lisi"
    //name4 = true

    //5.字符串



}

}
