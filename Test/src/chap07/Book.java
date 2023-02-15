package chap07;

public class Book {
    private int bid;
    private String name;
    private String author;
    private float price;
    private int num;
    private Category category;

    public Book() {}

    public Book(int bid) {
        super();
        this.bid = bid;
    }

    public Book(int bid, String name, String author, int num, Category category) {
        super();
        this.bid = bid;
        this.name = name;
        this.author = author;
        this.num = num;
        this.category = category;
    }

    public int getId() {
        return bid;
    }

    public void setId(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", category=" + category +
                '}';
    }
}
