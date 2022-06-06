import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的用户名：");
        String userName = scanner.nextLine();
        System.out.println("hello " + userName + "请问你是1.管理员》 0.普通用户》");
        int userChoose = scanner.nextInt();


    }
}
