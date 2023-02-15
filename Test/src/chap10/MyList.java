package chap10;

public interface MyList {
    /**
     * 在线性表的末尾添加元素
     * @param e 添加的元素
     */
    public void add(Object e);
    /**
     * 在线性表的任意位置添加一个元素
     * @param index 位置
     * @param e 拟添加的元素
     */
    public void add(int index,Object e);
    /**
     * 在线性表中是否包含某元素
     * @param e
     * @return 包含该元素，返回true，否则返回false
     */
    public boolean contains(Object e);
    /**
     * 在线性表中从前往后找该元素
     * @param e 拟查找的元素
     * @return 找见，返回下标，否则，返回-1
     */
    public int indexOf(Object e);
    /**
     * 在线性表中从后往前找该元素
     * @param e 拟查找的元素
     * @return 找见，返回下标，否则，返回-1
     */
    public int lastIndexOf(Object e);
    /**
     * 在线性表中移除该元素
     * @param e 拟移除的元素
     * @return 成功，返回true
     */
    public boolean remove(Object e);
    /**
     * 在线性表中移除某个位置的元素
     * @param index 拟移除元素的位置
     * @return 该位置上的元素值
     */
    public Object remove(int index);
    /**
     * 用某元素替换某位置上的值
     * @param index 拟替换的元素位置
     * @param e 用该元素来进行替换
     */
    public void replace(int index,Object e);
    /**
     * 返回线性表的长度
     * @return 线性表的长度
     */
    public int size();
    /**
     * 线性表是否为空？
     * @return 为空，返回true，否则，返回false
     */
    public boolean isEmpty();
    /**
     * 清空线性表
     */
    public void clear();
}
