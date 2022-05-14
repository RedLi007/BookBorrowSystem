package main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DBDelete {

    public static void dbDelete() {

        try {
            //连接数据库
            DBConn dbconn = new DBConn();
            dbconn.dbConn();
            Connection conn = dbconn.dbConn();
            //获取键盘输入
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入删除对象所在的表：");
            String table = sc.nextLine();
            System.out.println("请输入删除对象编号：");
            String condition = sc.nextLine();
            //调用删除存储过程
            String sql = " exec " + table + "_delete" + " @id= " + "'" + condition + "'";
            PreparedStatement statement = null;
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("对象已删除");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
