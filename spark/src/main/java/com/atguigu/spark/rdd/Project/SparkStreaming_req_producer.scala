package com.atguigu.spark.rdd.Project

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

import scala.collection.mutable.ListBuffer
import scala.util.Random

object SparkStreaming_req_producer {
  def main(args: Array[String]): Unit = {
    val topic = "spark-kafka"

    val prop = new Properties()
    // 添加配置
    prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "hadoop102:9092")
    prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](prop)
    while (true) {
      for (data <- mockData()) {
        val record = new ProducerRecord[String, String](topic, data)
        producer.send(record)
        println(data)
      }

      Thread.sleep(2000)
    }

  }

  def mockData() = {
    val areas = List("华北", "华南", "华中")
    val cities = List("北京", "上海", "深圳")

    val list = ListBuffer[String]()
    for (i <- 1 to new Random().nextInt(50)) {
      val userid: Int = new Random().nextInt(6) + 1
      val adid: Int = new Random().nextInt(6) + 1
      val area: String = areas(new Random().nextInt(3))
      val city: String = cities(new Random().nextInt(3))


      val dataString = s"${System.currentTimeMillis()}  ${area} ${city} ${userid} ${adid}"
      list.append(dataString)
    }
    list
  }
}
