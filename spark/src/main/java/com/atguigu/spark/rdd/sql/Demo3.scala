package com.atguigu.spark.rdd.sql

import org.apache.spark.sql.SparkSession

object Demo3 {
  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME", "atguigu")
    val spark: SparkSession = SparkSession
      .builder()
      .enableHiveSupport()
      .master("local[*]")
      .appName("sql")
      .getOrCreate()

    spark.sql("use test")
    spark.sql("select * from product_info").show()
    spark.stop()
  }
}
