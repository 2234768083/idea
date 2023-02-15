package nuc.ss.shopping.db;

import nuc.ss.shopping.entity.Book;
import nuc.ss.shopping.entity.Category;

public class BookDataSet {
    private Book[] books;// 书籍数据

    public BookDataSet() {
        books = new Book[10];
        Category category1 = new Category(1, "工具类", "软件编程");
        Category category2 = new Category(2, "小说类", "历史");

        books[0] = new Book("b00001", "程序设计", "谭浩强",45.6, 50, category1);
        books[1] = new Book("b00002", "离散数学", "严薇敏", 45.6 , 40, category2);
        books[2] = new Book("b00003", "数据结构", "严薇敏", 45.6,30, category2);
        books[3] = new Book("b00004", "面向对象程序设计", "耿祥义",45.6, 20, category2);
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

}
