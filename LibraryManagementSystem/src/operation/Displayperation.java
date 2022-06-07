package operation;

import books.BookList;

public class Displayperation implements IOperation {
    @Override
    public void work(BookList bookList) {

        System.out.println("书架里一共有" + bookList.getUserBookCount() + "本书，所有书的信息为: ");
        for (int i = 0; i < bookList.getUserBookCount(); i++) {
            System.out.println(bookList.getBooks(i));
        }
    }
}
