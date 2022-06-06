package user;

import java.util.Scanner;

public class Administrator extends User{

    public Administrator(String userName) {
        super(userName);
    }

    @Override
    public int menu() {
        System.out.println("1.添加图书");
        System.out.println("2.删除图书");
        System.out.println("3.新增图书");
        System.out.println("4.显示所有图书");
        System.out.println("0.退出系统");
        System.out.println("请输入您的操作");

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        return choose;
    }
}
