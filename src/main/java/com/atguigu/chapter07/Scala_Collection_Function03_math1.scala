package com.atguigu.chapter07

object Scala_Collection_Function03_math1{
  def main(args: Array[String]): Unit = {

    //TODO 1.集合--功能函数
    // sortWith -- 自定义排序
    val user1 =new User
    user1.salary = 1000
    user1.age = 20
    val user2 =new User
    user2.salary = 1600
    user2.age = 28
    val user3 =new User
    user3.salary = 1600
    user3.age = 30

    val list = List(
      user2,user1,user3
    )

    //默认先按照薪水，再按照年龄排序
    println(list.sortBy(_.salary))
    //List(User[1000,20], User[1600,28], User[1600,30])

    //TODO 自定义排序
    //排序的函数表示你认可排序规则，返回true，如果不认可，那么返回false
    val sorlist = list.sortWith(
      (user1, user2) => {
        if (user1.salary < user2.salary) {
          true
        } else if(user1.salary == user2.salary) {
           user1.age > user2.age
        }else{
          false
        }
      }
    )
    println(sorlist)    //List(User[1000,20], User[1600,30], User[1600,28])


  }

  class User {
    var salary : Int = _
    var age : Int = _

    override def toString: String = {
      s"User[${salary},${age}]"
    }
  }
}

