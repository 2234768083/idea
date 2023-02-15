package chap06;

/**
 *
 * @Title：Book
 * @Description：电商购物平台书籍类
 * @author：yzy
 * @date：2022年10月9日上午9:48:26
 *
 */

public class Book {
    private String bid;
    private String name;
    private String anthor;
    private int number;
    private Category category;
    /**
     * @param bid 书籍编号
     * @param name 名称
     * @param anthor 作者
     * @param number 库存
     * @param category 书籍类目
     */
    public Book(String bid, String name, String anthor, int number, Category category) {
        super();
        this.bid = bid;
        this.name = name;
        this.anthor = anthor;
        this.number = number;
        this.category = category;
    }
    @Override
    public String toString() {
        return "Book [bid=" + bid + ", name=" + name + ", anthor=" + anthor + ", number=" + number + ", category="
                + category + "]";
    }


}