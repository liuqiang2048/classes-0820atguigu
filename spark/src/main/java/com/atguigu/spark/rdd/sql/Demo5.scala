package com.atguigu.spark.rdd.sql

import org.apache.spark.sql.expressions.Aggregator
import org.apache.spark.sql.{Encoder, Encoders, SparkSession, functions}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Demo5 {
  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME", "atguigu")
    val spark: SparkSession = SparkSession
      .builder()
      .enableHiveSupport()      //启用Hive的支持
      .master("local[*]")
      .appName("sql")
      .getOrCreate()

    spark.sql("use test")
    spark.sql(
      s"""
         |SELECT
         |    a.*,
         |    c.area,
         |    c.city_name,
         |    p.product_name
         |FROM
         |    user_visit_action a
         |JOIN city_info c ON a.city_id = c.city_id
         |JOIN product_info p ON a.click_product_id=p.product_id
         |WHERE a.click_product_id > -1
         |""".stripMargin).createOrReplaceTempView("t1")
    val cityRemarkUdAF = new CityRemarkUdAF
    spark.udf.register("cityRemark", functions.udaf(cityRemarkUdAF))

    spark.sql(
      s"""
         |SELECT AREA,product_name,COUNT(*) clickCnt,cityRemark(city_name) cityRemark
         |FROM
         | t1
         |GROUP BY AREA,product_name
         |""".stripMargin).createOrReplaceTempView("t2")

    spark.sql(
      s"""
         |SELECT
         |    *,
         |    rank() over (PARTITION BY AREA ORDER BY clickCnt DESC ) rank
         | FROM
         | t2
         |""".stripMargin).createOrReplaceTempView("t3")

    spark.sql(
      """
        |SELECT
        |    *
        |FROM
        | t3
        | WHERE rank<=3
        |""".stripMargin).createOrReplaceTempView("t4")

    spark.sql("select * from t4").show(false)


    spark.stop()
  }

  case class CityBuff(var total: Long, var cityMap: mutable.Map[String, Long])

  class CityRemarkUdAF extends Aggregator[String, CityBuff, String] {
    override def zero: CityBuff = {
      CityBuff(0L, mutable.Map[String, Long]())
    }

    override def reduce(b: CityBuff, city: String): CityBuff = {
      b.total += 1
      val newCount: Long = b.cityMap.getOrElse(city, 0L) + 1
      b.cityMap.update(city, newCount)
      b
    }

    override def merge(b1: CityBuff, b2: CityBuff): CityBuff = {
      b1.total += b2.total
      val map1 = b1.cityMap
      val map2 = b2.cityMap
      map2.foreach {
        case (city, cnt) => {
          val newCount: Long = map1.getOrElse(city, 0L) + cnt
          map1.update(city, newCount)
        }
      }
      b1.cityMap = map1
      b1
    }

    override def finish(buff: CityBuff): String = {
      val ss: ListBuffer[String] = ListBuffer[String]()
      val totalCnt: Long = buff.total
      val cityMap: mutable.Map[String, Long] = buff.cityMap
      val sortList: List[(String, Long)] = cityMap.toList.sortBy(_._2)(Ordering.Long.reverse).take(2)
      val hasMore: Boolean = cityMap.size > 2
      var sum = 100L
      sortList.foreach {
        case (city, cnt) => {
          val r: Long = cnt * 100 / totalCnt
          ss.append(s"${city} ${r}%")
          sum = sum - r
        }
      }
      if (hasMore) {
        ss.append(s"其它 ${sum}%")
      }
      ss.mkString(",")
    }

    override def bufferEncoder: Encoder[CityBuff] = Encoders.product

    override def outputEncoder: Encoder[String] = Encoders.STRING
  }

}
