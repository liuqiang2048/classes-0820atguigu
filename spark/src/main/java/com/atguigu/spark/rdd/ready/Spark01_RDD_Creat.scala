package com.atguigu.spark.rdd.ready

object Spark01_RDD_Creat {
  def main(args: Array[String]): Unit = {

    //RDD的创建一般采用从内存，从磁盘中创建
    //
    //RDD需要处理的数据源可能来源于内存，也可能来自于文件

//
//    //TODO 1.准备Spark环境
////    准备Spark环境val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
//
//    //TODO 2.建立和Spark的连接
//    val sc = new SparkContext(sparkConf)
//
//    //TODO 从内存中加载数据集
//    //parallelize :并行，可以从内存数据源创建RDD
//    val seq = Seq(1,2,3,4)
//    val list = List(1,2,3,4)
//    val rdd: RDD[Int] = sc.parallelize(seq)
//    //makeRDD 的底层调用的就是parallelize
//    val rdd1: RDD[Int] = sc.makeRDD(seq)
//
//
//    sc.clone()
  }
}
