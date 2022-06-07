package user;

import books.BookList;
import operation.IOperation;

public abstract class User {

    // 用户名
    protected String userName;

    // IO接口数组，不初始化,
    protected IOperation[] iOperations;

    public User(String userName) {
        this.userName = userName;
    }

    /**
     * 用户菜单选择
     * @return 返回选择的int类型选项
     */
    public abstract int menu();

    /**
     * 操作menu方法返回的选项，来执行对应的类中重写的方法
     * @param choose IO数组要执行方法的下标
     * @param bookList 执行的对象
     */
    public void doPeration(int choose, BookList bookList) {
        this.iOperations[choose].work(bookList);
    }

}
