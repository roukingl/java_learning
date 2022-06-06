package user;

import java.util.Scanner;

public class NormalUser extends User {

    public NormalUser(String userName) {
        super(userName);
    }

    @Override
    public int menu() {
        System.out.println("1.借阅图书");
        System.out.println("2.归还图书");
        System.out.println("3.显示所有图书");
        System.out.println("0.退出系统");

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        return choose;
    }
}
