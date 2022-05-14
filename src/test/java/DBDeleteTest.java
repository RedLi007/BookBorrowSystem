package test.java;

import main.java.DBDelete;
import org.junit.jupiter.api.Test;

public class DBDeleteTest {

    @Test
    public static void main (String[] args) {

        DBDelete dbdelete = new DBDelete();
        dbdelete.dbDelete();

    }

}
