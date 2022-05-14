package main.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LogIn {

    public static String[] logIn() {

        String str = null;
        String[] info = new String[3];
        //从键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的账号：");
        String adno = sc.nextLine();
        System.out.println("请输入账号密码：");
        String password = sc.nextLine();
        //连接数据库
        DBConn dbconn = new DBConn();
        dbconn.dbConn();
        Connection conn = dbconn.dbConn();
        try {
            //根据输入账号查询密码
            String sql = " exec admin_select " + " @id= " + "'" + adno + "'";
            PreparedStatement statement = null;
            statement = conn.prepareStatement(sql);
            ResultSet res = null;
            res = statement.executeQuery();
            //结果处理，获得密码
            while (res.next()) {
                str = res.getString("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (password.equals(str.replace(" ", ""))) {
            System.out.println("登录成功");
            //将账号密码返回
            info[0] = "success";
            info[1] = adno;
            info[2] = password;
        } else {
            System.out.println("登录失败");
            info[0] = "defeat";
        }
        return info;

    }

}
