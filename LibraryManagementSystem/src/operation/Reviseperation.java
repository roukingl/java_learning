package operation;

import books.Book;
import books.BookList;

import java.util.Scanner;

public class Reviseperation implements IOperation {
    @Override
    public void work(BookList bookList) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入你要修改的书的名字：");
        String reviseBookNameBefore = scanner.nextLine();


        for (int i = 0; i < bookList.getUserBookCount(); i++) {
            if(reviseBookNameBefore.equals(bookList.getBooks(i).getBookName())) {
                System.out.print("请输入修改后的书的名字：");
                String reviseBookNameAfter = scanner.nextLine();

                System.out.print("请输入修改后的书的作者：");
                String reviseBookAuthorAfter = scanner.nextLine();

                System.out.print("请输入修改后的书的类型：");
                String reviseBookTypeAfter = scanner.nextLine();

                System.out.print("请输入修改后的书的价格：");
                int reviseBookPriceAfter = scanner.nextInt();

                Book reviseBook = new Book(reviseBookNameAfter, reviseBookAuthorAfter, reviseBookTypeAfter, reviseBookPriceAfter);

                bookList.setBooks(i, reviseBook);
                System.out.println("修改成功! ");

                return;
            }
        }

        System.out.println("找不到该书，无法修改!");
    }
}
