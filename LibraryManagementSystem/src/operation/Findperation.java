package operation;

import books.BookList;

public class Findperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书");
    }
}
