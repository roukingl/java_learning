import books.BookList;
import user.*;

import java.util.Scanner;

public class Main {

    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的名字: ");
        String userName = scanner.nextLine();

        System.out.println("Hello" + userName + "请输入你的身份：》1.管理员 》0.普通用户");
        int identityChoice = scanner.nextInt();
        if(identityChoice == 1) {
            return new Administrator(userName);
        } else {
            return new NormalUser(userName);
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();

        User user = login();

        while(true) {
            int operateChoice = user.menu();
            user.doPeration(operateChoice, bookList);
        }
    }
}
