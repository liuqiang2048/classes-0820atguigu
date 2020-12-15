package com.atguigu.chapter07

import scala.io.Source

object ScalaWordCout_1 {
  def main(args: Array[String]): Unit = {

    //TODO WordCount
    //单词 ->出现次数
    //分析   设计   开发
//TODO 需求：不同省份的商品点击排行
    val dataList = List( ("zhangsan", "河北", "鞋"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "鞋"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河南", "衣服"),
      ("wangwu", "河南", "鞋"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "鞋"),
      ("zhangsan", "河北", "鞋"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "帽子"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河南", "衣服"),
      ("wangwu", "河南", "帽子"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "帽子"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "电脑"),
      ("zhangsan", "河南", "鞋"),
      ("lisi", "河南", "衣服"),
      ("wangwu", "河南", "电脑"),
      ("zhangsan", "河南", "电脑"),
      ("lisi", "河北", "衣服"),
      ("wangwu", "河北", "帽子"))

//TODO 1.对数据进行结构转换
    val mapList = dataList.map(
      t => {
        t._2+"_"+t._3
      }
    )

    //TODO 2.将转换结构后的数据进行分组聚合
    val dataMap :Map[String,List[String]]=
      mapList.groupBy(data=>data)

    val dataToCount = dataMap.mapValues(list=>list.size)
    //TODO 3.将聚合的结果进行结构转换

    val prvToDataCountList = dataToCount.toList.map(
      t => {
        val k = t._1
        val v = t._2
        val ks = k.split("_")
        (ks(0), (ks(1), v))
      }
    )


    //TODO 4.将转换结构后的数据按照省份进行分组
val groupMap = prvToDataCountList.groupBy(_._1)

    //TODO 将分组后的数据根据点击进行排序取前三名
    val top3 = groupMap.mapValues(
      list => {
        val newList = list.map(_._2)
        newList.sortBy(_._2)(Ordering.Int.reverse).take(3)
      }
    )
    top3
    println((top3))
  }

}
