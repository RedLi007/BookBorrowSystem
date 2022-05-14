package main.java;

import java.sql.*;

public class DBConn {

    private static Connection conn = null;

    public static Connection dbConn() {

        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Library_MB";
        try {
            //1.加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.连接
            conn = DriverManager.getConnection(dbURL, "sa", "LiHD13829810212");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
