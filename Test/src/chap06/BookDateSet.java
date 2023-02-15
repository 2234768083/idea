package chap06;

/**
 *
 * @Title：BookDateSet
 * @Description：模拟书籍数据库
 * @author：yzy
 * @date：2022年10月9日上午9:49:59
 *
 */

public class BookDateSet {
    private Book[] books;

    //构造方法
    public BookDateSet() {
        books = new Book[4];
        books[0] = new Book("b00001", "数据结构与算法", "严蔚敏", 30,  new Category(1,"软件开发","算法设计"));
        books[1] = new Book("b00002", "java编程技术", "李华玲", 20,  new Category(2,"软件开发","java"));
        books[2] = new Book("b00003", "数据库概论", "蒋本珊", 25,  new Category(3,"软件开发","数据库"));
        books[3] = new Book("b00004", "c语言程序设计", "谭浩强", 35, new Category(4,"软件开发","c语言"));
    }

    //得到所有的书籍
    public Book[] getBooks() {
        return books;
    }
}