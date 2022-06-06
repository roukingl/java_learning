package books;

public class BookList {

    private Book[] books = new Book[10];

    // 当前的图书数量
    private int userBookCount;

    public BookList() {
        books[0] = new Book("三国演义","罗贯中", "小说", 19);
        books[1] = new Book("西游记","吴承恩","小说", 29);
        books[2] = new Book("红楼梦","曹雪芹","小说", 20);
        userBookCount = 3;
    }

    /**
     * 获得书架上下标为bookSubscript的书
     * @param bookSubscript 书架上书的下标
     * @return 返回那本书
     */
    public Book getBooks(int bookSubscript) {
        return books[bookSubscript];
    }

    /**
     * 修改书架上下标为bookSubscript的书
     * @param bookSubscript 同上，下标
     * @param book 修改后的信息
     */
    public void setBooks(int bookSubscript, Book book) {
        this.books[bookSubscript] = book;
    }

    /**
     * 获得当前书的个数
     * @return 返回书的个数（int类型）
     */
    public int getUserBookCount() {
        return userBookCount;
    }

    /**
     * 获得int类型参数，修改书的个数为这个int类型的数字
     * @param userBookCount 要修改的int类型数字
     */
    public void setUserBookCount(int userBookCount) {
        this.userBookCount = userBookCount;
    }
}
