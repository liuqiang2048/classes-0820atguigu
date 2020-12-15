//package com.atguigu.spark.rdd.sql
//
//import org.apache.spark.Aggregator
//import org.apache.spark.sql.expressions.{MutableAggregationBuffer}
//import org.apache.spark.sql.types.{DataType, LongType, StructField, StructType}
//import org.apache.spark.sql.{DataFrame, Row, SparkSession}
//
//
//object SparkSQL04_Test_UDAF {
//  def main(args: Array[String]): Unit = {
//    //创建环境
//    val spark: SparkSession = SparkSession.builder().master("local[*]")
//      .appName("SparkSQL").getOrCreate()
//
//    val df: DataFrame = spark.read.json("input/users.json")
//    df.createOrReplaceGlobalTempView("user")
//
//    //todo 1.创建聚合函数
//    val udaf = new MyAvg
//
//    spark.udf.register("MyAvg",udaf)
//    // UDF函数称之为用户自定义函数，但是这个函数是不能聚合的
//    // 只能对每一条进行处理。
//    // zhangsan => "Name : zhangsan"
//    // 如果想要使用sql完成聚合功能，那么必须采用特殊的函数：自定义聚合函数UDAF
//自定义聚合函数UDAF
//    spark.sql("select MyAvg(age) from user").show
//
//    spark.stop()
//
//  }
//
//  //TODO 2.自定义年龄平均值的聚合函数
//  //继承UserDefinedAggregateFunction类
//  //重写里面方法
////  class MyAvg extends Aggregator{
////
////  }
//}