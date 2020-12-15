package com.atguigu.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HBase05_API {
    public static void main(String[] args) throws IOException {
        //建立zk的连接设置，用于连接Hbase
        final Configuration cfg = HBaseConfiguration.create();
        cfg.set("hbase.zookeeper.quorum", "hadoop102,hadoop103,hadoop104");

        //获取连接对象
        Connection connection = ConnectionFactory.createConnection(cfg);
        final Admin admin = connection.getAdmin();

        //todo 给表增加数据
        //首先获取表
        TableName student = TableName.valueOf("test:student");
        Table table = connection.getTable(student);

        //给表增加数据
        //
        String rowkey = "1001";
        //增加数据时，需要创建Put的对象，同时需要指定RowKey
        Put put = new Put(Bytes.toBytes(rowkey));
        //增加数据列
        put.addColumn(
          Bytes.toBytes("info"),
          Bytes.toBytes("name"),
          Bytes.toBytes("zhangsan")

        );
        table.put(put);
        System.out.println("新增数据成功");


        admin.close();
        connection.close();
    }
}
