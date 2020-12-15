package com.atguigu.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HBase02_API {
    public static void main(String[] args) throws IOException {
        //建立zk的连接设置，用于连接Hbase
        final Configuration cfg = HBaseConfiguration.create();
        cfg.set("hbase.zookeeper.quorum", "hadoop102,hadoop103,hadoop104");


        //获取连接对象
        Connection connection = ConnectionFactory.createConnection(cfg);
        final Admin admin = connection.getAdmin();

        //todo 判断表是否存在

        //默认查询default命名空间表格，前面叫冒号也可以指定命名空间
        final TableName student = TableName.valueOf("test:student");
        final boolean b = admin.tableExists(student);
        if (b){
            System.out.println("表已经存在");
        }else {
            System.out.println("表不存在");

            final TableDescriptorBuilder builder =
                    TableDescriptorBuilder.newBuilder(student);

            // 创建表格
           String cfName = "info";
            byte[] bs = Bytes.toBytes(cfName);
            ColumnFamilyDescriptorBuilder columnFamilyDescriptorBuilder =
                    ColumnFamilyDescriptorBuilder.newBuilder(bs);

            builder.setColumnFamily(columnFamilyDescriptorBuilder.build());

             admin.createTable(builder.build());
             System.out.println("表创建成功");
        }

        admin.close();
        connection.close();
    }
}
