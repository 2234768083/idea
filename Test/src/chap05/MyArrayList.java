package chap05;

import java.util.Arrays;
import java.util.Scanner;

public class MyArrayList {
    private int size = 5;
    private int CAPACITY;
    private String[] datas = new String[size];
    private String data;


    // 数组初始化
    public void initArray() {
        for (int i = 0; i < size; i++) {
            Scanner sc = new Scanner(System.in);
            datas[i] = sc.next();
        }

    }

    // 打印(遍历)数组
    public void printArray() {

        for (String s : datas) {
            System.out.print(s + " ");
        }

    }

    // 修改数组
    public void insertArray() {
        System.out.println("请输入要插入的位置：");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        index = index - 1;
        System.out.println("请输入要插入的内容：");
        data = sc.next();
        // 复制一个长度+1的数组
        datas = Arrays.copyOf(datas, datas.length + 1);

        // 将要插入的数字位置的后面数字后移
        for (int i = datas.length - 1; i > index; i--) {
            datas[i] = datas[i - 1];
        }
        // 插入数字
        datas[index] = data;

    }

    // 删除数组元素
    public void DeleteArray() {
        System.out.println("请输入要删除的位置：");
        Scanner sc = new Scanner(System.in);
        CAPACITY = sc.nextInt();

        // 判断元素是否越界
        if (CAPACITY < 0 || CAPACITY >= datas.length) {
            throw new RuntimeException("元素越界... ");
        }
        for (int i = CAPACITY; i < datas.length - 1; i++) {
            datas[i] = datas[i + 1];
        }
        datas = Arrays.copyOf(datas, datas.length - 1);
        // 最后一位数据赋值为0，占位，同时告知用户这是一个无效数据
        // datas[datas.length - 1] = "null";

    }

    // 查找数组
    public void selectArrray() {
        System.out.println("请输入要查找的位置：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num < 0 || num >= datas.length) {
            throw new RuntimeException("查找越界... ");
        }
        System.out.println(datas[num - 1]);
    }

    // 返回线性表长度
    public void sizeArrray() {
        System.out.println("线性表长度为" + datas.length);
    }

    // 线性表判空
    public void emptyArray() {
        if (datas.length > 0) {
            System.out.println("该线性表不为空");
        } else {
            System.out.println("线性表为空");
        }

    }

    // 清空线性表
    public void clearArray() {
        Arrays.fill(datas, null);
        if (datas.length > 0) {
            System.out.println("清空成功！MyArray为空");
        } else {
            System.out.println("清空失败！MyArray不为空");
        }
    }

    // 线性表替换
    public void setArray() {
        System.out.println("请输入要替换的位置：");
        Scanner sc = new Scanner(System.in);
        CAPACITY = sc.nextInt() + 1;
        System.out.println("请输入要替换的内容：");
        data = sc.next();
        datas[CAPACITY] = data;

    }

    // 判断线性表中是否还有某个元素
    public void judgeArray() {
        System.out.println("请输入要查找的元素：");
        Scanner sc = new Scanner(System.in);
        data = sc.next();
        for (String s : datas) {
            if (data == s || data != null && s.equals(data)) {

                System.out.println("存在该元素");
            }

        }

    }

    // 反向查找（根据元素判断位置）
    public void unselectArray() {
        System.out.println("请输入要查找的元素：");
        Scanner sc = new Scanner(System.in);
        data = sc.next();
        for (int i = 0; i < datas.length; i++) {
            if (data == datas[i] || data != null && datas[i].equals(data)) {
                System.out.println("元素所在位置为" + (i + 1));

            }
        }

    }

    // 末尾插入元素
    public void lastIndextArrray() {
        System.out.println("请输入要插入的内容：");
        Scanner sc = new Scanner(System.in);
        data = sc.next();
        datas = Arrays.copyOf(datas, datas.length + 1);
        datas[datas.length - 1] = data;

    }

}