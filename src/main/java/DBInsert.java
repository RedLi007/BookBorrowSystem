package main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DBInsert {

    public static void dbInsert() {

        String sql = null;
        try {
            //连接数据库
            DBConn dbconn = new DBConn();
            dbconn.dbConn();
            Connection conn = dbconn.dbConn();
            //获取键盘输入
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入添加对象所在的表：");
            String table = sc.nextLine();
            //添加对象SQL语句
            if (table.equals("admin")) {
                System.out.println("请输入相应的属性值：adno,adname,sex,password");
                String str1 = sc.nextLine();
                String str2 = sc.nextLine();
                String str3 = sc.nextLine();
                String str4 = sc.nextLine();
                sql = " insert into admin(adno,adname,sex,password) values " + "('" + str1 + "','" + str2 + "','" + str3 + "','" + str4 + "')";
            } else if (table.equals("book")) {
                System.out.println("请输入相应的属性值：bno,bname,sort,borrow");
                String str1 = sc.nextLine();
                String str2 = sc.nextLine();
                String str3 = sc.nextLine();
                String str4 = sc.nextLine();
                sql = " insert into book(bno,bname,sort,borrow) values " + "('" + str1 + "','" + str2 + "','" + str3 + "','" + str4 + "')";
            } else if (table.equals("borrow")) {
                System.out.println("请输入相应的属性值：mno,bno,start_date,return_date");
                String str1 = sc.nextLine();
                String str2 = sc.nextLine();
                String str3 = sc.nextLine();
                String str4 = sc.nextLine();
                sql = " insert into borrow(mno,bno,start_date,return_date) values " + "('" + str1 + "','" + str2 + "','" + str3 + "','" + str4 + "')";
            } else if (table.equals("department")) {
                System.out.println("请输入相应的属性值：dno,dept_name,header");
                String str1 = sc.nextLine();
                String str2 = sc.nextLine();
                String str3 = sc.nextLine();
                sql = " insert into department(dno,dept_name,header) values " + "('" + str1 + "','" + str2 + "','" + str3 + "')";
            } else if (table.equals("member")) {
                System.out.println("请输入相应的属性值：mno,mname,sex,dno,spno");
                String str1 = sc.nextLine();
                String str2 = sc.nextLine();
                String str3 = sc.nextLine();
                String str4 = sc.nextLine();
                String str5 = sc.nextLine();
                sql = " insert into member(mno,mname,sex,dno,spno) values " + "('" + str1 + "','" + str2 + "','" + str3 + "','" + str4 + "','" + str5 +"')";
            } else if (table.equals("speciality")) {
                System.out.println("请输入相应的属性值：spno,dno,spname");
                String str1 = sc.nextLine();
                String str2 = sc.nextLine();
                String str3 = sc.nextLine();
                sql = " insert into speciality(spno,dno,spname) values " + "('" + str1 + "','" + str2 + "','" + str3 + "')";
            }
            PreparedStatement statement = null;
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("对象已添加");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
