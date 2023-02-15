package chap08;


public class Book {
    private String bid;
    private String name;
    private String author;
    private int number;
    private Category category;

    public Book(String bid, String name, String author, int number, Category category) {
        super();
        this.bid = bid;//书的编号
        this.name = name;//书名
        this.author = author;//书的作者
        this.number = number;//书剩余的量
        this.category = category;//书的类别
    }
    @Override
    public String toString() {
        return "Book [书的编号=" + bid + ", 书名=" + name + ", 作者=" + author + ", 剩余的数量=" + number + ", 类目="
                + category + "]";
    }



}
