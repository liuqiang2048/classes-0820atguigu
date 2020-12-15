package com.atguigu.spark.rdd.sql

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}


object SparkSQL01_Test {
  def main(args: Array[String]): Unit = {


    //todo Spark SQL
    //创建环境
    val spark: SparkSession = SparkSession.builder().master("local[*]")
      .appName("SparkSQL").getOrCreate()

    // 这里的spark不是包名，而是SparkSession的对象名
    // 一般情况下，需要在创建SparkSession对象后，增加导入
    import spark.implicits._


    //创建的json文件中的整个文件的数据应该符合json的语法规则
    //RDD读取文件的时候是一行的读取的，所以sparksql读取json文件时，要求一行数据符合json格式

    //todo DataFrame
    val df: DataFrame = spark.read.json("input/users.json")
//    df.show()

    //TODO SQL
    df.createOrReplaceTempView("user")
//    spark.sql("select * from user").show
//    spark.sql("select avg(age) from user").show
//
//    df.select("id","name").show

    //todo DSL
    // DSL语法需要在当前环境中引入SparkSQL的隐式转换规则。
//    df.select("id", "name").show
//    df.select('age).show
//    df.select($"age"+1).show

    //todo DataSet
    val seq = Seq(1,2,3,4)
    val ds: Dataset[Int] = seq.toDS()

    // TODO RDD & DataFrame & Dataset

    // RDD => DataFrame
    val rdd: RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(List((1, "zhangsan", 30), (2, "lisi", 40)
      , (3, "wangwu", 50)))
    val df1: DataFrame = rdd.toDF("id","name","age")

    // DataFrame => RDD
    val rdd1: RDD[Row] = df1.rdd

    // DataFrame => Dataset
    val ds1: Dataset[User] = df.as[User]

    // Dataset => DataFrame
    val frame: DataFrame = ds1.toDF()

    // RDD => Dataset
    val userDS: Dataset[User] = rdd.map {
      case (id, name, age) => {
        User(id, name, age)
      }
    }.toDS()


    // Dataset => RDD
    val rdd2: RDD[User] = userDS.rdd


    //关闭资源
    spark.stop()

  }
  case class User(id:Int,name:String,age:Int)
}
