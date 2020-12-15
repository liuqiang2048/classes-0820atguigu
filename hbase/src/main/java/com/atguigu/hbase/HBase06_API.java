package com.atguigu.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Iterator;

public class HBase06_API {
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

        //查询单挑数据
        Get get = new Get(Bytes.toBytes("1001"));
        Result result = table.get(get);
        Cell[] cells = result.rawCells();
        for (Cell cell : cells) {
            System.out.println(Bytes.toString(CellUtil.cloneFamily(cell)));
            System.out.println(Bytes.toString(CellUtil.cloneQualifier(cell)));
            System.out.println(Bytes.toString(CellUtil.cloneValue(cell)));

        }
        System.out.println("=============");
        //todo 查询全表数据
        Scan scan = new Scan();
        ResultScanner scanner = table.getScanner(scan);
        Iterator<Result> iterator = scanner.iterator();
        while (iterator.hasNext()){
            Result next = iterator.next();
            Cell[] cells1 = next.rawCells();
            for (Cell cell : cells1) {
                System.out.println(Bytes.toString(CellUtil.cloneFamily(cell)));
                System.out.println(Bytes.toString(CellUtil.cloneQualifier(cell)));
                System.out.println(Bytes.toString(CellUtil.cloneValue(cell)));
            }
        }

        admin.close();
        connection.close();
    }
}
