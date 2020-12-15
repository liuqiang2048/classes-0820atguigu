package com.atguigu.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class HBase04_API {
    public static void main(String[] args) throws IOException {
        //建立zk的连接设置，用于连接Hbase
        final Configuration cfg = HBaseConfiguration.create();
        cfg.set("hbase.zookeeper.quorum", "hadoop102,hadoop103,hadoop104");

        //获取连接对象
        Connection connection = ConnectionFactory.createConnection(cfg);
        final Admin admin = connection.getAdmin();

        //todo 删除表
        //删除之前需要将表格禁用，放置有其他操作
        //如果删除表不存在，会发生错误；
        //所以代码实现时，需要先判断表是否存在
        TableName student = TableName.valueOf("test:student1");
        admin.disableTable(student);
        admin.deleteTable(student);



        admin.close();
        connection.close();
    }
}
