package com.atguigu.spark.rdd.sql

import org.apache.spark.sql.SparkSession

object Demo2 {
  def main(args: Array[String]): Unit = {

    System.setProperty("HADOOP_USER_NAME", "atguigu")
    val spark: SparkSession = SparkSession
      .builder()
      .enableHiveSupport()
      .master("local[*]")
      .appName("sql")
      .getOrCreate()

    spark.sql("use test")
    spark.sql(
      s"""
         |CREATE TABLE `user_visit_action`(
         |  `date` string,
         |  `user_id` bigint,
         |  `session_id` string,
         |  `page_id` bigint,
         |  `action_time` string,
         |  `search_keyword` string,
         |  `click_category_id` bigint,
         |  `click_product_id` bigint,
         |  `order_category_ids` string,
         |  `order_product_ids` string,
         |  `pay_category_ids` string,
         |  `pay_product_ids` string,
         |  `city_id` bigint)
         |row format delimited fields terminated by '\t';
         |""".stripMargin)

    spark.sql(
      s"""
         |load data local inpath 'input1/user_visit_action.txt' into table user_visit_action;
         |""".stripMargin)

    spark.sql(
      s"""
         |CREATE TABLE `product_info`(
         |  `product_id` bigint,
         |  `product_name` string,
         |  `extend_info` string)
         |row format delimited fields terminated by '\t';
         |""".stripMargin)
    spark.sql(
      s"""
         |load data local inpath 'input1/product_info.txt' into table product_info;
         |""".stripMargin)

    spark.sql(
      s"""
         |CREATE TABLE `city_info`(
         |  `city_id` bigint,
         |  `city_name` string,
         |  `area` string)
         |row format delimited fields terminated by '\t';
         |""".stripMargin)

    spark.sql(
      s"""
         |load data local inpath 'input1/city_info.txt' into table city_info;
         |""".stripMargin)

    spark.sql("select * from city_info;").show()
    spark.stop()
  }
}
