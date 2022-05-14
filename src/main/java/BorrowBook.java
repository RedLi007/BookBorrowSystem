package main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BorrowBook {

    public static void borrowBook() {

        String sql = null;
        try {
            //连接数据库
            DBConn dbconn = new DBConn();
            dbconn.dbConn();
            Connection conn = dbconn.dbConn();
            //获取键盘输入
            Scanner sc = new Scanner(System.in);
            //添加对象SQL语句
            System.out.println("请输入相应的属性值：mno,bno,start_date,return_date");
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String str3 = sc.nextLine();
            String str4 = sc.nextLine();
            sql = " insert into borrow(mno,bno,start_date,return_date) values " + "('" + str1 + "','" + str2 + "','" + str3 + "','" + str4 + "')";
            PreparedStatement statement = null;
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("借书成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
