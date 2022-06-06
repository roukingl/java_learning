package operation;

import books.BookList;

public class Displayperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("打印图书");
    }
}
