package test_2022.java_10_1;

import java.io.*;
import java.util.Scanner;


// 简单实现用户查询指定目录中指定文件名中的关键字询问是否删除
public class Demo1 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的目录");
        File file = new File(scanner.next());
        if (!file.exists()) {
            System.out.println("要查询的目录不存在");
        }
        System.out.println("请输入要查询的字符");
        String name = scanner.next();
        serchFileName(file, name);
    }

    private static void serchFileName(File file, String name) throws IOException {
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                serchFileName(f, name);
            } else {
                checkFileName(f, name);
            }
        }
    }

    private static void checkFileName(File f, String name) throws IOException {
        if (f.getName().contains(name)) {
            System.out.println(f.getParent() + " 路径下有文件 " + f.getName() + " 该文件名中有关键字 " + name + " 是否需要删除 (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if (choice.equals("y") || choice.equals("Y")) {
                f.delete();
            }
        }
    }
}
