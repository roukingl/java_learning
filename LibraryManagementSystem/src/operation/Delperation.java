package operation;

import books.BookList;

public class Delperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
    }
}
