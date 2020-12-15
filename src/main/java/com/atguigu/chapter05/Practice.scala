package com.atguigu.chapter05

import scala.util.control.Breaks

object Practice {
  def main(args: Array[String]): Unit = {
    //  for (i <- Range(1,5)){//范围集合
    //    println("i= " +i)
    //  }
    //    for (i <- 1 to 5){//包含5
    //      println("i="+i)
    //    }
    //    for(i <- 1 until 5){//不包含5
    //      println("i ="+i)
    //    }
    //
    //    for(i <- Range(1,5,2)){
    //      println("i="+i)
    //    }
    //
    //    for(i <- 1 to 5 by 2){
    //      println("i ="+i)
    //    }
    //
//        for (i <- Range(1,5) if i != 3){
//          println("i="+i)
//        }

//    for (i <- Range(1, 5); j <- Range(1, 4)) {
//      println("i=" + i + ",j=" + j)
//
//      for (j <- Range(1, 4)) {
//        println("i=" + i + ",j=" + j)
//      }
//    }


//    for (i <-Range(1,5); j=i-1){
//      println("j="+j)
//    }

//    val result = for (i<-Range(1,5)) yield {
//      i*2
//    }
//    println(result)

//    var i = 0;
//    while (i<5){
//      println(i)
//      i+=1
//    }


    //do while 循环
//    var a = 5;
//    do{
//      println(a)
//    }while(a<5)

    //循环中断
Breaks.breakable{
  for(i<- 1 to 5){
    if (i==3){
      Breaks.break;
    }
    println(i)
  }
}

  }
}