package operation;

import books.BookList;

import java.security.spec.RSAOtherPrimeInfo;

public class Exitperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
    }
}
