package test_2022.java_7_26;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for (char ch: str2.toUpperCase().toCharArray()) {
                set1.add(ch);
            }
            for (char ch: str1.toUpperCase().toCharArray()) {
                if (!set1.contains(ch) && !set2.contains(ch)) {
                    System.out.print(ch);
                    set2.add(ch);
                }
            }
        }
    }
}
