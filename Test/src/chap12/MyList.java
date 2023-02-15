package chap12;

public interface MyList {
    /**
     * 在线性表末尾添加一个元素
     * @param e拟添加的元素
     */
    public void add(Object e);
    /**
     * 在线性表的某个位置插入某个元素
     * @param index提供插入位置
     * @param e拟插入的元素
     */
    public void add(int index, Object e);
    /**
     * 线性表中是否包含某元素
     * @param e 拟查找的元素
     * @return 包含，返回true；不包含，返回false
     */
    public boolean contaims(Object e);
    /**
     * 在线性表中从前往后查找某元素
     * @param e 拟查找的元素
     * @return 找见，返回下标，没有找到返回-1；
     */
    public int indexOf(Object e);
    /**
     * 在线性表中从后往前查找某元素
     * @param e 拟查找的元素
     * @return 找见，返回下标，没有找到返回-1；
     */
    public int LastIndexOf(Object e);
    /**
     * 在线性表中移除某元素
     * @param e 拟移除的元素
     * @return 删除成功，返回true，否者返回false；
     */
    public boolean remove(Object e);
    /**
     * 在线性表中移除某位置的元素
     * @param index 拟移除的元素的位置
     * @return 拟移除位置的元素
     */
    public  Object remove(int index);
    /**
     * 替换线性表中某位置上的元素
     * @param index 拟替换的元素的位置
     * @param e 用该元素来替换
     */
    public void replace(int index,Object e);
    /**
     * 获取线性表的长度
     * @return 线性表的而长度
     */
    public int size();
    /**
     * 判断线性表是否空
     * @return空，返回true，否则返回false
     */
    public boolean isEmpty();
    /**
     * 清空线性表
     */
    public void clear();
    /**
     *
     */
    public void menu();
    /**
     * @param e
     * @return
     */

}
