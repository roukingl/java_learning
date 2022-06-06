package operation;

import books.BookList;

public interface IOperation {

    /**
     * 接口，用于实现业务接口
     * @param bookList 把bookList作为参数，操作这个参数
     */
    void work(BookList bookList);
}
