package com.atguigu.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class HBase01_API {
    public static void main(String[] args) throws IOException {

        //建立zk的连接设置，用于连接Hbase
        final Configuration cfg = HBaseConfiguration.create();
        cfg.set("hbase.zookeeper.quorum", "hadoop102,hadoop103,hadoop104");


        //获取连接对象
        Connection connection = ConnectionFactory.createConnection(cfg);
        final Admin admin = connection.getAdmin();


        //todo 命名空间的操作
        //创建命名空间
        final NamespaceDescriptor nd = NamespaceDescriptor.create("atguigu1").build();

        admin.createNamespace(nd);
        System.out.println("命名空间创建完毕");

        admin.close();
        connection.close();



    }
}
