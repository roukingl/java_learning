import java.util.Scanner;

/**
 * 主类
 * 主程序的运行都在此类中
 */
public class Main {

    /**
     * 该类负责用户输入登录信息判断有没有异常，有什么异常。无返回值
     * @param Name 用户输入的用户名
     * @param Password 用户输入的密码
     */
    public static void LoginSystem(String Name, String Password) {
        String userName = "dingruihang";
        String userPassword = "123456";

        if( !userName.equals(Name) ) {
            throw new NameException("输入错误");
        }
        if( !userPassword.equals(Password) ) {
            throw new PasswordException("输入错误");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String userName = input.nextLine();
        String userPassword = input.nextLine();

        try {
            LoginSystem(userName, userPassword);
            System.out.println("登录成功");
        } catch (NameException user) {
            System.out.println("用户名输入错误");
        } catch (PasswordException user){
            System.out.println("密码输入错误");
        } finally {
            input.close();
        }

        System.out.println("其他运行逻辑");

    }

}

  /*      private static void testMethod(){

            System.out.println("testMethod");

        }

        public static void main(String[] args) {

            ((Main)null).testMethod();

    }

}*/
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String str = in.nextLine();
            int ret = str.lastIndexOf(' ');
            System.out.println(str.length() - ret - 1);
        }
    }
}*/
/*

class Solution {
    public int firstUniqChar(String s) {

        int[] count = new int[26];

        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
        }

        for(int i = 0;i < s.length();i++) {
            if(count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}*/
