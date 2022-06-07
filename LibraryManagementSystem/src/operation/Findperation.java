package operation;

import books.Book;
import books.BookList;

import java.util.Scanner;

public class Findperation implements IOperation {
    @Override
    public void work(BookList bookList) {

        System.out.print("请输入你要查找书的名字：");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();

        for (int i = 0; i < bookList.getUserBookCount(); i++) {
            if(bookName.equals(bookList.getBooks(i).getBookName())) {
                System.out.println("找到了，书的信息是：");
                System.out.println(bookList.getBooks(i));
                return;
            }
        }

        System.out.println("找不到该书，无法查找");
    }
}
