package chap06;

/**
 *
 * @Title：Category
 * @Description：
 * @author：yzy
 * @date：2022年10月9日上午11:50:42
 *
 */

public class Category {
    private int id;
    private String firstlevel;
    private String secondlevel;

    //全参数的构造方法
    public Category(int id,String firstlevel,String secondlevel) {
        this.id = id;
        this.firstlevel = firstlevel;
        this.secondlevel = secondlevel;
    }
    //Object类的toString()方法:软件开发->Java语言
    @Override
    public String toString() {
        return firstlevel + "->" + secondlevel;
    }
}
