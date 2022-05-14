package main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ReturnBook {

    public static void returnBook() {

        try {
            //连接数据库
            DBConn dbconn = new DBConn();
            dbconn.dbConn();
            Connection conn = dbconn.dbConn();
            //获取键盘输入
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入还书人员编号：");
            String condition = sc.nextLine();
            //调用删除存储过程
            String sql = " exec " + " borrow_delete " + " @id= " + "'" + condition + "'";
            PreparedStatement statement = null;
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("还书成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
