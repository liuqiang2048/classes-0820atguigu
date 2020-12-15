package com.atguigu.spark.rdd.sql

import org.apache.spark.sql.expressions.Aggregator
import org.apache.spark.sql.{Encoder, Encoders, SparkSession, functions}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Demo6 {
  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME", "atguigu")
    val spark: SparkSession = SparkSession
      .builder()
      .enableHiveSupport() //启用Hive的支持
      .master("local[*]")
      .appName("sql")
      .getOrCreate()

    spark.sql("use test")
    spark.sql(
      """
        |SELECT
        |    a.*,
        |    c.area,
        |    c.city_name,
        |    p.product_name
        |FROM  user_visit_action a
        |JOIN  product_info p ON a.click_product_id=p.product_id
        |JOIN  city_info c ON  a.city_id=c.city_id
        |""".stripMargin).createOrReplaceTempView("t1")
    spark.sql(
      """
        |SELECT
        |AREA,
        |product_name,
        | COUNT(*) clickCnt
        | FROM
        | t1
        | GROUP BY AREA,product_name
        |""".stripMargin).createOrReplaceTempView("t2")

    spark.sql(
      """
        | SELECT
        | *,
        | rank() over(PARTITION BY AREA ORDER BY clickCnt DESC) rank
        | FROM
        | t2
        |""".stripMargin).createOrReplaceTempView("t3")

    spark.sql(
      """
        | SELECT
        | *
        | FROM
        | t3
        | WHERE rank<=3
        |""".stripMargin).createOrReplaceTempView("t4")
    spark.sql("select * from t4").show(false)
  }

}
