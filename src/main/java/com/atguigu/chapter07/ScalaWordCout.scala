package com.atguigu.chapter07

import scala.io.Source

object ScalaWordCout {
  def main(args: Array[String]): Unit = {

    //TODO WordCount
    //单词 ->出现次数
    //分析   设计   开发

    //TODO 1.读取数据文件
    //     val lsit: List[String] = Source.fromFile("input/word.txt").getLines().toList

    val in = Source.fromFile("input/word.txt")
    val  lineList :List[String] = in.getLines().toList
    in.close()

    //TODO 2.将读取的每一行字符串拆分成为一个一个的单词
      val words = lineList.flatMap(line=> line.split(" "))

    //TODO 3.将相同的单词分在一个组中
     val wordTolistMap :Map[String,List[String]] = words.groupBy(word=>word)

    //TODO 4.将相同的单词统计出现的数量
      val wordToCountMap:Map[String,Int] = wordTolistMap.map(
        t=>{
          val word = t._1
          val list = t._2
          (word,list.size)
        }
      )

    //TODO 5. 将统计的结果进行排序（降序)
      val sortList = wordToCountMap.toList.sortBy(_._2)(Ordering.Int.reverse)

    //TODO 6.将统计的结果进行排序（降序）
   println(sortList.take(3))
  }

}
