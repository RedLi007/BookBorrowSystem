package test.java;

import main.java.DBConn;
import org.junit.jupiter.api.Test;

public class DBConnTest {

    @Test
    public static void main (String[] args) {

        DBConn dbconn = new DBConn();
        dbconn.dbConn();

    }

}
