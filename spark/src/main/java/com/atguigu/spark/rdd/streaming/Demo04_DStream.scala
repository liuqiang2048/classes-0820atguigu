package com.atguigu.spark.rdd.streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable
import scala.util.Random

object Demo04_DStream {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]")
      .setAppName("SparkStreaming")
    val ssc = new StreamingContext(sparkConf,Seconds(3))

    //创建自定义数据采集器
    val receiver = new MyReceive
    //引用自定义采集器
    val inputStream = ssc.receiverStream(receiver)
    val mappedStream = inputStream.map((_,1))
    val reducedStream = mappedStream.reduceByKey(_+_)

    reducedStream.print()
    ssc.start()
    ssc.awaitTermination()

  }
  class MyReceive extends Receiver[String](StorageLevel.MEMORY_ONLY){
    private  var flowFlg = true
    override def onStart(): Unit = {
      while(flowFlg){
        Thread.sleep(100)
        //生成数据
        val data = new Random().nextInt(10).toString
        //存储数据
        store(data)
      }

    }

    override def onStop(): Unit = {
      flowFlg = false
    }
  }
}
