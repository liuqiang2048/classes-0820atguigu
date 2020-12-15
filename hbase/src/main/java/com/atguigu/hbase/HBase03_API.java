package com.atguigu.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class HBase03_API {
    public static void main(String[] args) throws IOException {
        //建立zk的连接设置，用于连接Hbase
        final Configuration cfg = HBaseConfiguration.create();
        cfg.set("hbase.zookeeper.quorum", "hadoop102,hadoop103,hadoop104");

        //获取连接对象
        Connection connection = ConnectionFactory.createConnection(cfg);
        final Admin admin = connection.getAdmin();

        //todo 创建表格



        admin.close();
        connection.close();
    }
}
