package com.atguigu.chapter07

object Practice_5 {
  def main(args: Array[String]): Unit = {

        //TODO 计算函数

     val list = List(1,2,3,4)
     val list1 = List(3,4,5,6)

     //1.集合最小值
     println(list.min)
     //2.集合最大值
     println(list.max)
     //3.集合求和
     println(list.sum)
     //4.集合乘奇
     println(list.product)


     //5.集合简约化

     //scala提供了自定义计算的函数
     //reduce：-聚合功能（简化，规约）解决的是集合内元素运算的问题
     //scala中数据计算的方法用的最多的就是：两两计算
     def reduceFunction(x:Int,y:Int):Int={
        x+y
     }

     //质简原则
//     println(list.reduce(reduceFunction))
//     list.reduce((x:Int,y:Int)=>{x+y})
//     list.reduce((x,y)=>x+y)
//     list.reduce(_+_)
     println(list.reduce(_ + _))

     //5.1集合简约化（左）
     println(list.reduceLeft(_ - _))
     //5.2集合简约化（右）
     println(list.reduceRight(_ - _))

     //6.折叠
     //集合外部的数据和集合内部的进行两两计算
     //fold方法存在两个参数
     //第一个参数列表表示计算的初始值
     //第二个参数列表表示两两数值计算的逻辑
     //fold只是支持同类型集合的计算，如果集合元素类型不同，需要用foldleft
     println(list.fold(6)(_ - _))
     println(list.fold(6)(_ + _))

     //6.1foldLeft
     println(list.foldLeft(0)(_ - _))
     //6.2 foldRight
     //底层原理和集合简约化的reduceRight一样
     //把初始值调到最后，再进行计算
     //底层源码：reverse.foldLeft(z)((right, left) => op(left, right))
     println(list.foldRight(0)(_ + _))

     //7.集合扫描
     //查看折叠集合每一步运算的结果
     println(list.fold(0)(_ - _))   //-10
     println(list.scan(0)(_ - _))   //List(0, -1, -3, -6, -10)

     println(list.foldRight(0)(_ - _)) //-2
     println(list.scanRight(0)(_ - _)) //List(-2, 3, -1, 4, 0)



  }
}