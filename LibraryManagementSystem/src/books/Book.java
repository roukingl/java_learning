package books;

public class Book {

    // 书名
    private String bookName;

    // 书的作者
    private String bookAuthor;

    // 书的类型
    private String bookType;

    // 书的价格
    private int bookPrice;

    // 书的借出状态
    private boolean bookState;

    public Book() {

    }

    public Book(String bookName, String bookAuthor, String bookType, int bookPrice) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookType = bookType;
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public boolean isBookState() {
        return bookState;
    }

    public void setBookState(boolean bookState) {
        this.bookState = bookState;
    }

    @Override
    public String toString() {
        return "{" +
                "书名：'" + bookName + '\'' +
                ", 作者：'" + bookAuthor + '\'' +
                ", 类型：'" + bookType + '\'' +
                ", 价格：=" + bookPrice +
                ", " + ((bookState ? "已借出" : "未借出")) +
                '}';
    }

}
