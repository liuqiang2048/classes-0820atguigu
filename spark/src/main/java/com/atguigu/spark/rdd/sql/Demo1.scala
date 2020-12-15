package com.atguigu.spark.rdd.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Demo1 {
  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME", "atguigu")

  val spark: SparkSession = SparkSession
    .builder()
    .enableHiveSupport()
    .master("local[*]")
    .appName("sql")
    .getOrCreate()
    import spark.implicits._
    spark.sql("show tables")
  }
}
