package chap08;

import java.util.Scanner;
public class BookDateSet {
    Scanner sc = new Scanner(System.in);
    static Book[] books;
    static int Booknum;
    public BookDateSet() {
        System.out.println("请输入书籍信息:");
        System.out.println("请输入要输入的书籍数量");
        int Booknum = sc.nextInt();
        books = new Book[Booknum];
        for(int i=0; i<=Booknum-1; i++) {
            Set(i);
        }

    }
    public static void Set(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第"+(i+1)+"本书的信息");
        System.out.println("输入第"+(i+1)+"本书的---书的编号");
        System.out.println("格式1，2，3，4，5.......");
        String bid = sc.next();
        System.out.println("输入第"+(i+1)+"本书的---书名");
        String name = sc.next();
        System.out.println("输入第"+(i+1)+"本书的---作者");
        String author = sc.next();
        System.out.println("输入第"+(i+1)+"本书的---剩余的数量");
        int number = sc.nextInt();
        System.out.println("输入第"+(i+1)+"本书的---类目ID");
        float id = sc.nextFloat();
        System.out.println("输入第"+(i+1)+"本书的---第一类目");
        String firstLevel = sc.next();
        System.out.println("输入第"+(i+1)+"本书的---第二类目");
        String secondLevel = sc.next();
        books[i] = new Book(bid,name,author,number, new Category(id,firstLevel,secondLevel));

    }
    public Book[] getBooks() {
        return books;
    }

}

