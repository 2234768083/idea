package chap08;

import java.util.Scanner;
public class BooksWork {
    public void Getbook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要获取第几本书的信息:");
        int num = sc.nextInt();
        System.out.println(BookDateSet.books[num-1]);
    }

    public void BookChange() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要改变第几本书的信息:");
        int changenum = sc.nextInt();
        BookDateSet.Set(changenum-1);

    }

}


