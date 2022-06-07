package user;

import operation.*;

import java.util.Scanner;

public class Administrator extends User{

    public Administrator(String userName) {
        super(userName);
        this.iOperations = new IOperation[] {
                new Exitperation(),
                new Addperation(),
                new Delperation(),
                new Reviseperation(),
                new Displayperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("1.新增图书");
        System.out.println("2.删除图书");
        System.out.println("3.修改图书");
        System.out.println("4.显示所有图书");
        System.out.println("0.退出系统");
        System.out.println("请输入您的操作");

        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        return choose;
    }
}
