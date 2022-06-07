package user;

import operation.*;

import java.util.Scanner;

public class NormalUser extends User {

    public NormalUser(String userName) {
        super(userName);
        this.iOperations = new IOperation[] {
                new Exitperation(),
                new BorrowOperation(),
                new ReturnOperation(),
                new Findperation(),
                new Displayperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("1.借阅图书");
        System.out.println("2.归还图书");
        System.out.println("3.查找图书");
        System.out.println("4.显示所有图书");
        System.out.println("0.退出系统");

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        return choose;
    }
}
