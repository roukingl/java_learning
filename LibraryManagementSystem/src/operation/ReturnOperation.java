package operation;

import books.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {

        System.out.print("请输入你要归还书的名字：");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();

        for (int i = 0; i < bookList.getUserBookCount(); i++) {
            if(bookName.equals(bookList.getBooks(i).getBookName())) {
                bookList.getBooks(i).setBookState(false);
                System.out.println("归还成功！");
                return;
            }
        }

        System.out.println("没有找到该书，无法归还");
    }
}
