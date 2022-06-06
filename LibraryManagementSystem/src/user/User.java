package user;

import books.BookList;
import operation.IOperation;

public abstract class User {
    protected String userName;
    protected IOperation[] iOperations;

    public User(String userName) {
        this.userName = userName;
    }

    public abstract int menu();

    public void doPeration(int choose, BookList bookList) {
        this.iOperations[choose].work(bookList);
    }

}
