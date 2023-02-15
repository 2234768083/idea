package chap06;

/**
 *
 * @Title：MainClass
 * @Description：测试书籍数据库
 * @author：
 * @date：2022年10月9日上午11:25:14
 *
 */
public class MainClass {

    public static void main(String[] args) {

        BookDateSet bds = new BookDateSet();

        Book[] books = bds.getBooks();

        for(Book b: books) {
            System.out.println(b);
        }

    }

}
