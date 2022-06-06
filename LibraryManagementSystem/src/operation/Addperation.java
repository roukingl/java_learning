package operation;

import books.BookList;

public class Addperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("增加图书");
    }
}
