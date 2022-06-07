package operation;

import books.Book;
import books.BookList;

import java.util.Scanner;

public class Addperation implements IOperation {
    @Override
    public void work(BookList bookList) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入你要增加的书的名字：");
        String addBookName = scanner.nextLine();
        System.out.print("请输入你要增加的书的作者：");
        String addBookAuthor = scanner.nextLine();
        System.out.print("请输入你要增加的书的类型：");
        String addBookType = scanner.nextLine();
        System.out.print("请输入你要增加的书的价格：");
        int addBookPrice = scanner.nextInt();

        Book addBook = new Book(addBookName, addBookAuthor, addBookType, addBookPrice);

        int count = bookList.getUserBookCount();
        bookList.setBooks(count, addBook);
        bookList.setUserBookCount(count + 1);
        System.out.println("新增图书成功");
    }
}
