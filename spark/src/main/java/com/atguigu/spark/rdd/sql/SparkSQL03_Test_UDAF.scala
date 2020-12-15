package com.atguigu.spark.rdd.sql

import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}


object SparkSQL03_Test_UDAF {
  def main(args: Array[String]): Unit = {
    //创建环境
    val spark: SparkSession = SparkSession.builder().master("local[*]")
      .appName("SparkSQL").getOrCreate()

    import spark.implicits._

    val df: DataFrame = spark.read.json("input/users.json")
    df.createOrReplaceGlobalTempView("user")

    //todo 1.创建聚合函数
    val udaf = new MyAvg

    spark.udf.register("MyAvg",udaf)
    // UDF函数称之为用户自定义函数，但是这个函数是不能聚合的
    // 只能对每一条进行处理。
    // zhangsan => "Name : zhangsan"
    // 如果想要使用sql完成聚合功能，那么必须采用特殊的函数：自定义聚合函数UDAF

    spark.sql("select MyAvg(age) from user").show

    spark.stop()

  }

  //TODO 2.自定义年龄平均值的聚合函数
  //继承UserDefinedAggregateFunction类
  //重写里面方法
  class MyAvg extends UserDefinedAggregateFunction{
    override def inputSchema: StructType = {
      StructType(Array(StructField("age", LongType)))
    }

    override def bufferSchema: StructType = {
      StructType(Array(
        StructField("total", LongType),
        StructField("count", LongType)
      ))
    }

    override def dataType: DataType = {
      LongType
    }

    override def deterministic: Boolean = {
      true
    }

    override def initialize(buffer: MutableAggregationBuffer): Unit = {
      buffer.update(0,0L)
      buffer.update(1,0L)
    }

    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      buffer.update(0, buffer.getLong(0) + input.getLong(0))
      buffer.update(1, buffer.getLong(1) + 1)
    }

    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      buffer1.update(0, buffer1.getLong(0) + buffer2.getLong(0))
      buffer1.update(1, buffer1.getLong(1) + buffer2.getLong(1))
    }

    override def evaluate(buffer: Row): Any = {
      buffer.getLong(0) / buffer.getLong(1)
    }
  }
}