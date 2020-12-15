package com.atguigu.spark.rdd.sql

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}


object SparkSQL02_Test_UDF {
  def main(args: Array[String]): Unit = {

    //todo Spark SQL
    //创建环境
    val spark: SparkSession = SparkSession.builder().master("local[*]")
      .appName("SparkSQL").getOrCreate()

    // 这里的spark不是包名，而是SparkSession的对象名
    // 一般情况下，需要在创建SparkSession对象后，增加导入
    import spark.implicits._

    val df: DataFrame = spark.read.json("input/users.json")

    df.createOrReplaceTempView("user")

    spark.udf.register("prefixName", (name:String)=>{ "Name : " + name })

    spark.sql("select prefixName(name) from user").show

    //关闭资源
    spark.stop()

  }

  case class  User(id:Int,name:String,age:Int)
}