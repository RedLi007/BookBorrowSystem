package main.java;

import java.util.Scanner;

public class SystemStart {

    public static void main(String[] args) {

        int op1 = 0;
        int op2 = 0;
        int op3 = 0;
        String[] str = new String[3];
        Scanner sc = new Scanner(System.in);
        System.out.println("****欢迎使用图书借阅登记管理系统****");
        //登录模块
        do {
            System.out.println("1、登录管理员账号 2、退出");
            op1 = sc.nextInt();
            str[0] = "defeat";
            switch (op1) {
                case 1:
                    LogIn login = new LogIn();
                    str = login.logIn();
                    break;
                case 2:
                    System.exit(0);
            }
        } while (str[0].equals("success") == false);

        //功能模块
        do {
            System.out.println("1、借书登记 2、还书登记 3、管理系统信息库 4、退出");
            op2 = sc.nextInt();
            switch (op2) {
                case 1:
                    BorrowBook borrowbook = new BorrowBook();
                    borrowbook.borrowBook();
                    break;
                case 2:
                    ReturnBook returnbook = new ReturnBook();
                    returnbook.returnBook();
                    break;
                case 3:
                    //管理系统信息库模块
                    do {
                        System.out.println("1、查看系统表 2、查询数据 3、添加对象 4、删除对象 5、修改数据 6、退出");
                        op3 = sc.nextInt();
                        switch (op3) {
                            case 1:
                                ReportForms reportforms = new ReportForms();
                                reportforms.reportForms();
                                break;
                            case 2:
                                DBSelect dbs = new DBSelect();
                                dbs.dbSelect();
                                break;
                            case 3:
                                DBInsert dbinsert = new DBInsert();
                                dbinsert.dbInsert();
                                break;
                            case 4:
                                DBDelete dbdelete = new DBDelete();
                                dbdelete.dbDelete();
                                break;
                            case 5:
                                DBUpdate dbupdate = new DBUpdate();
                                dbupdate.dbUpdate();
                                break;
                            case 6:
                                System.exit(0);
                        }
                    } while (op3 != 1 && op3 != 2 && op3 != 3 && op3 != 4 && op3 != 5);
                    break;
                case 4:
                    System.exit(0);
            }
        } while (op2 != 1 && op2 != 2 && op2 != 3);

    }

}
