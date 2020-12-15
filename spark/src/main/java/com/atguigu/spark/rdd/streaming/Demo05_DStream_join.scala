package com.atguigu.spark.rdd.streaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.util.Random

object Demo05_DStream_join {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]")
      .setAppName("SparkStreaming")
    val ssc = new StreamingContext(sparkConf,Seconds(3))

    val ds1 = ssc.socketTextStream("hadoop102",9999)
    val ds2 = ssc.socketTextStream("hadoop102",8888)

    val kv1: DStream[(String, Int)] = ds1.map((_,1))
    val kv2: DStream[(String, Int)] = ds2.map((_,1))

    val joinDS: DStream[(String, (Int, Int))] = kv1.join(kv2)
    joinDS.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
