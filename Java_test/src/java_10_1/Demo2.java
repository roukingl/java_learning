package java_10_1;

import java.io.*;
import java.util.Scanner;

// 简单实现一个文件的复制
public class Demo2 {

    /*public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入源文件");
        File inputFile = new File(scanner.next());
        System.out.println("请输入目标文件");
        File outputFile = new File(scanner.next());
        if (!inputFile.isFile()) {
            System.out.println("输入源文件有误");
            return;
        }
        if (!outputFile.getParentFile().isDirectory()) {
            System.out.println("输入目标文件有误");
            return;
        }
        try (OutputStream outputFileStream = new FileOutputStream(outputFile);
             InputStream inputFileStream = new FileInputStream(inputFile)) {
            while (true) {
                int ret = inputFileStream.read();
                if (ret == -1) {
                    System.out.println("复制完毕");
                    break;

                }
                outputFileStream.write(ret);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main1(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要复制的文件");
        String inputFilePath = scanner.next();
        System.out.println("请输入复制后的文件");
        String outputFilePath = scanner.next();
        try (OutputStream outputFile = new FileOutputStream(outputFilePath);
             InputStream inputFile = new FileInputStream(inputFilePath)) {
            while (true) {
                int ret = inputFile.read();
                if (ret == -1) {
                    System.out.println("复制完毕");
                    break;

                }
                outputFile.write(ret);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
