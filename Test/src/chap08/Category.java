package chap08;


public class Category {
    private float id;
    private String firstLevel;
    private String secondLevel;
    /**
     * @param id 编号
     * @param firstLevel 一级类目
     * @param secondLevel 二级类目
     */
    public Category(float id, String firstLevel, String secondLevel) {
        this.id = id;
        this.firstLevel = firstLevel;//第一类目
        this.secondLevel = secondLevel;//第二类目
    }

    @Override
    // 软件开发>java语言
    public String toString() {
        return id + "->" + firstLevel + "->" + secondLevel;
    }


}
