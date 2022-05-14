package main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DBUpdate {

    public static void dbUpdate() {

        String sql = null;
        try {
            //连接数据库
            DBConn dbconn = new DBConn();
            dbconn.dbConn();
            Connection conn = dbconn.dbConn();
            //获取键盘输入
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入修改属性名：");
            String nature = sc.nextLine();
            System.out.println("请输入修改属性所在的表：");
            String table = sc.nextLine();
            System.out.println("请输入修改对象编号：");
            String condition = sc.nextLine();
            System.out.println("请输入修改后的值：");
            String elem = sc.nextLine();
            //修改数据SQL语句
            if (table.equals("member")) {
                sql = " update " + table + " set " + nature + " = " + "'" + elem + "'" + " where mno = " + "'" + condition + "'";
            } else if (table.equals("department")) {
                sql = " update " + table + " set " + nature + " = " + "'" + elem + "'" + " where dno = " + "'" + condition + "'";
            } else if (table.equals("book")) {
                sql = " update " + table + " set " + nature + " = " + "'" + elem + "'" + " where bno = " + "'" + condition + "'";
            } else if (table.equals("admin")) {
                sql = " update " + table + " set " + nature + " = " + "'" + elem + "'" + " where adno = " + "'" + condition + "'";
            } else if (table.equals("speciality")) {
                sql = " update " + table + " set " + nature + " = " + "'" + elem + "'" + " where spno = " + "'" + condition + "'";
            } else if (table.equals("borrow")) {
                sql = " update " + table + " set " + nature + " = " + "'" + elem + "'" + " where mno = " + "'" + condition + "'";
            }
            PreparedStatement statement = null;
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("数据已修改");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
