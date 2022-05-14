package test.java;

import main.java.LogIn;
import org.junit.jupiter.api.Test;

public class LogInTest {

    @Test
    public static void main(String[] args) {

        LogIn login = new LogIn();
        String[] str = login.logIn();
        System.out.println(str[0]);
        System.out.println(str[1]);
        System.out.println(str[2]);

    }

}
