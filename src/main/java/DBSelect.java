package main.java;

import java.sql.*;
import java.util.Scanner;

public class DBSelect {

    public static void dbSelect() {

        try {
            //连接数据库
            DBConn dbconn = new DBConn();
            dbconn.dbConn();
            Connection conn = dbconn.dbConn();
            //获取键盘输入
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入查询属性：");
            String result = sc.nextLine();
            System.out.println("请输入查询的表：");
            String table = sc.nextLine();
            System.out.println("请输入对应编号：");
            String condition = sc.nextLine();
            //调用查询存储过程
            String sql = " exec " + table + "_select" + " @id= " + "'" + condition + "'";
            PreparedStatement statement = null;
            statement = conn.prepareStatement(sql);
            ResultSet res = null;
            res = statement.executeQuery();
            //结果处理
            while (res.next()) {
                String str = res.getString(result);
                System.out.println("查询结果为：" + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
