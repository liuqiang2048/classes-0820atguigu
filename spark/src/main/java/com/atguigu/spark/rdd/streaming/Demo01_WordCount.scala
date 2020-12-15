package com.atguigu.spark.rdd.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Demo01_WordCount {
  def main(args: Array[String]): Unit = {

    //1.初始化Spark配置信息
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("StreamWordCount")

    //2.初始化SparkStreamingContext
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    val lineStreams: ReceiverInputDStream[String] = ssc.socketTextStream("hadoop102",9999)


    val result: DStream[(String, Int)] = lineStreams.flatMap(_.split(" "))
      .map((_, 1)).reduceByKey(_ + _)

    result.print()
    ssc.start()
    ssc.awaitTermination()




// //   3.通过监控端口创建DStream，读进来的数据为一行行
//        val lineStreams = ssc.socketTextStream("linux1", 9999)
//
//        //将每一行数据做切分，形成一个个单词
//        val wordStreams = lineStreams.flatMap(_.split(" "))
//
//        //将单词映射成元组（word,1）
//        val wordAndOneStreams = wordStreams.map((_, 1))
//
//        //将相同的单词次数做统计
//        val wordAndCountStreams = wordAndOneStreams.reduceByKey(_+_)
//
//        //打印
//        wordAndCountStreams.print()
//
//        //启动SparkStreamingContext
//        ssc.start()
//        ssc.awaitTermination()



  }
}
