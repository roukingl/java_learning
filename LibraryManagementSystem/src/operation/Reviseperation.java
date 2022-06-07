package operation;

import books.BookList;

public class Reviseperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("修改图书");
    }
}
