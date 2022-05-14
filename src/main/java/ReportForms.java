package main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ReportForms {

    public static void reportForms() {

        try {
            //连接数据库
            DBConn dbconn = new DBConn();
            dbconn.dbConn();
            Connection conn = dbconn.dbConn();
            //获取键盘输入
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您想查看的表（member、department、speciality、borrow、book、admin）：");
            String table = sc.nextLine();
            //查询表SQL语句
            String sql = " select * from " + table;
            PreparedStatement statement = null;
            statement = conn.prepareStatement(sql);
            ResultSet res = null;
            res = statement.executeQuery();
            //结果处理
            if (table.equals("member")) {
                System.out.println("mno mname sex dno spno");
                while (res.next()) {
                    String str1 = res.getString("mno");
                    String str2 = res.getString("mname");
                    String str3 = res.getString("sex");
                    String str4 = res.getString("dno");
                    String str5 = res.getString("spno");
                    System.out.println(str1 + " " + str2 + " " + str3 + " " + str4 + " " + str5);
                }
            }
            if (table.equals("department")) {
                System.out.println("dno dept_name header");
                while (res.next()) {
                    String str1 = res.getString("dno");
                    String str2 = res.getString("dept_name");
                    String str3 = res.getString("header");
                    System.out.println(str1 + " " + str2 + " " + str3);
                }
            }
            if (table.equals("speciality")) {
                System.out.println("spno dno spname");
                while (res.next()) {
                    String str1 = res.getString("spno");
                    String str2 = res.getString("dno");
                    String str3 = res.getString("spname");
                    System.out.println(str1 + " " + str2 + " " + str3);
                }
            }
            if (table.equals("borrow")) {
                System.out.println("mno bno start_date return_date");
                while (res.next()) {
                    String str1 = res.getString("mno");
                    String str2 = res.getString("bno");
                    String str3 = res.getString("start_date");
                    String str4 = res.getString("return_date");
                    System.out.println(str1 + " " + str2 + " " + str3 + " " + str4);
                }
            }
            if (table.equals("book")) {
                System.out.println("bno bname sort borrow");
                while (res.next()) {
                    String str1 = res.getString("bno");
                    String str2 = res.getString("bname");
                    String str3 = res.getString("sort");
                    String str4 = res.getString("borrow");
                    System.out.println(str1 + " " + str2 + " " + str3 + " " + str4);
                }
            }
            if (table.equals("admin")) {
                System.out.println("adno adname sex password");
                while (res.next()) {
                    String str1 = res.getString("adno");
                    String str2 = res.getString("adname");
                    String str3 = res.getString("sex");
                    String str4 = res.getString("password");
                    System.out.println(str1 + " " + str2 + " " + str3 + " " + str4);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
