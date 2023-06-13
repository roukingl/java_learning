package test_2022.java_10_1;

import java.io.*;
import java.util.Scanner;

public class Demo3 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的目录路径");
        File file = new File(scanner.next());
        System.out.println("请输入要查找的关键字");
        String keyWord = scanner.next();

        serchFileNameAndContent(file, keyWord);
    }

    private static void serchFileNameAndContent(File file, String keyWord) throws FileNotFoundException {
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                serchFileNameAndContent(f, keyWord);
            } else {
                checkFile(f, keyWord);
            }
        }
    }

    private static void checkFile(File f, String keyWord){
        if (f.getName().contains(keyWord)) {
            System.out.println(f.getParent() + " 路径下有文件 " + f.getName() + " 名字中有关键字 " + keyWord);
        }
        try (InputStream inputStream = new FileInputStream(f)) {
            StringBuilder stringBuilder = new StringBuilder();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine()).append("\n");
            }
            if (stringBuilder.indexOf(keyWord) > -1) {
                System.out.println(f.getParent() + " 路径下有文件 " + f.getName() + " 内容中有关键字 " + keyWord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
