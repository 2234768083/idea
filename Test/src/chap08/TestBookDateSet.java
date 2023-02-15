package chap08;

import java.util.Scanner;

public class TestBookDateSet {

    public static void main(String[] args) {
        BookDateSet bds = new BookDateSet();
        BooksWork abs = new BooksWork();
        //输入数据
        Book[] books = bds.getBooks();
        //改变数据
        abs.BookChange();
        //输出全部数据
        for(Book b:books) {
            System.out.println(b);
        }
        //查询编号为num的书籍信息
        abs. Getbook();

    }

}
