package chap12;

import java.util.Arrays;

public class MyArrayList extends MyAbstractList{

    //定义线性表的（数字）的初始化空间大小
    public static final int CAPACITY = 50;
    private Object[] data = new Object[CAPACITY];

    public MyArrayList() {}

    public MyArrayList(Object[] data) {
        super(data);
    }
    public void add(int index, Object e) {
        //移动元素
        for (int i=size-1; i>=index; i--) {
            data[i+1] = data[i];
        }
        //插入元素
        data[index] = e;
        //大小修改
        size++;
    }

    @Override
    public boolean contaims(Object e) {
        // TODO Auto-generated method stub
        for(int i=0; i<size; i++) {
            if(data[i].equals(e)==true) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object e) {
        // TODO Auto-generated method stub
        for(int i=0;i<size;i++) {
            if(data[i].equals(e)==true) {
                return i;
            }
        }
        return -1;
    }
    public int LastIndexOf(Object e) {
        // TODO Auto-generated method stub
        for(int i=size-1;i>0;i--) {
            if(data[i].equals(e)==true) {
                return i;
            }
        }
        return -1;
    }
    public void replace(int index, Object e) {

        data[index] = e;


    }

    @Override
    public void clear() {
        size = 0;
        // TODO Auto-generated method stub

    }
    public String toString() {
        //[中国，美国，日本]
        StringBuffer result = new StringBuffer("[");
        for (int i=0; i<size; i++) {
            result.append(data[i]);
            if(i < size-1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }
    public void menu() {
        System.out.println("************************");
        System.out.println("*0:显示菜单：*");
        System.out.println("*1*在线性表末尾添加元素*");
        System.out.println("*2*在线性表某位置插入元素*");
        System.out.println("*3*线性表中是否包含某元素（包含，返回true；不包含，返回false）*");
        System.out.println("*4*在线性表中从前往后查找某元素（找见，返回下标，没有找到返回-1）*");
        System.out.println("*5*在线性表中从后往前查找某元素（找见，返回下标，没有找到返回-1）*");
        System.out.println("*6*在线性表中移除某元素（删除成功，返回true，否者返回false）*");
        System.out.println("*7*在线性表中移除某位置的元素（返回被移除的元素）*");
        System.out.println("*8*用一个元素替换线性表中某位置上的元素*");
        System.out.println("*9*输出线性表*");
        System.out.println("*10*输出线性表长度*");
        System.out.println("*11*判断是否为空*");
        System.out.println("*12*清空线性表*");
        System.out.println("*13*返回*");
        System.out.println("************************");

    }


    @Override
    public Object remove(int index) {
        int n=index-1;
        Object b;
        b = data[index];
        for(int i=0; i<size-index; i++) {
            data[n]=data[n+1];
            n++;
        }
        size--;
        return b;
    }

}
