package java_test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextInt();
        int jinzhi = scanner.nextInt();
        List<Character> list = new ArrayList<>();
        while (number != 0) {
            list.add(fun(number, jinzhi));
            number /= jinzhi;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i));
        }
    }

    private static Character fun(long number, int jinzhi) {
        long ret = number % jinzhi;
        if (ret < 10) {
            long ch = ret + '0';
            return (char)ch;
        } else {
            long ch = ret + 'A' - 10;
            return (char)ch;
        }
    }
}

    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = scan.nextInt();
        }
        int countA = -1;
        int countB = -1;
        int countC = -1;
        countA = (arr[0] + arr[2]) / 2;
        if (countA < 0) {
            System.out.println("No");
            return;
        }
        countB = (arr[1] + arr[3]) / 2;
        if (countB < 0) {
            System.out.println("No");
            return;
        }
        countC = arr[0] + arr[3] - countA;
        if (countC < 0) {
            System.out.println("No");
            return;
        }
        System.out.println(countA + " " + countB + " " + countC);
    }*/
