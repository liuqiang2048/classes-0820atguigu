package com.atguigu.chapter07

object Practice_4 {
  def main(args: Array[String]): Unit = {

        //TODO 衍生集合

     val list = List(1,2,3,4)
     val list1 = List(1,2,3,4)
     val list2 = List(3,4,5,6)

      //1.集合头
     println(list.head)
     //2.集合尾
     println(list.tail)
     //3.集合尾迭代
     println(list.tails)
     //4.集合初始值
     println(list.init)
     //5.集合初始值迭代
     println(list.inits)
     //6.集合最后元素
     println(list.last)
     //7.集合并集
     println(list.union(list1))
     //8.集合交集
     println(list.intersect(list2))
     //9.集合差集
     println(list.diff(list2))

     //10.切分集合
     println(list.splitAt(2))
     //11.滑动窗口
     val iterator = list.sliding(2)
     while (iterator.hasNext){
        println(iterator.next())
     }

     iterator  //<iterator>
     //12.滚动（没有重复）
     val iterator1 = list.sliding(3, 1)
     while (iterator1.hasNext){
        println(iterator1.next())
     }
     //13.拉链
     println(list.zip(list2))
     //14.数据索引拉链
     println(list.zipWithIndex)
  }
}