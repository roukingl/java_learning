package operation;

import books.BookList;

import java.util.Scanner;

public class Delperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入你要删除书的名字：");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();

        for (int i = 0; i < bookList.getUserBookCount(); i++) {
            if(bookName.equals(bookList.getBooks(i).getBookName())) {
                for (int j = i; j < bookList.getUserBookCount() - 1; j++) {
                    bookList.setBooks(j, bookList.getBooks(j + 1));
                }
                bookList.setBooks(bookList.getUserBookCount() - 1, null);
                bookList.setUserBookCount(bookList.getUserBookCount() - 1);
                return;
            }
        }

        System.out.println("没有找到该书，无法删除书籍");
    }
}
