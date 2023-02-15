package chap05;

import java.util.Scanner;

public class TestArrayList {
    public static void main(String[] args) {
        System.out.println("--------欢迎来到数组管理系统---------");
        System.out.println("1. 线性表初始化");
        System.out.println("2. 插入线性表数据元素");
        System.out.println("3. 查找线性表");
        System.out.println("4. 返回线性表长度");
        System.out.println("5. 线性表判空");
        System.out.println("6. 线性表替换");
        System.out.println("7. 判断线性表中是否还有某个元素");
        System.out.println("8. 反向查找（根据元素判断位置）");
        System.out.println("9. 末尾插入元素");
        System.out.println("10. 删除线性表");
        System.out.println("11. 遍历线性表");
        System.out.println("12. 退出");

        MyArrayList ma = new MyArrayList();
        while (true) {
            System.out.println("请输入你的选择：");

            // 键盘录取数据
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            // switch 语句完成操作
            switch (line) {
                case "1":
                    System.out.println(" -------数组初始化--------");
                    ma.initArray();
                    ma.printArray();
                    System.out.println(" ");
                    break;
                case "2":
                    System.out.println(" -------插入线性表数据元素--------");
                    ma.insertArray();
                    ma.printArray();
                    System.out.println(" ");
                    break;
                case "3":
                    System.out.println(" -------查找线性--------");
                    ma.selectArrray();
                    System.out.println(" ");
                    break;
                case "4":
                    System.out.println(" -------返回线性表长度--------");
                    ma.sizeArrray();
                    System.out.println(" ");
                    break;
                case "5":
                    System.out.println("------线性表判空------");
                    ma.emptyArray();
                    System.out.println(" ");
                    break;
                case "6":
                    System.out.println(" -------线性表替换--------");
                    ma.setArray();
                    ma.printArray();
                    System.out.println(" ");
                    break;
                case "7":
                    System.out.println(" --------判断线性表中是否还有某个元素-------");
                    ma.judgeArray();
                    System.out.println(" ");
                    break;
                case "8":
                    System.out.println(" --------反向查找（根据元素判断位置）-------");
                    ma.unselectArray();
                    System.out.println(" ");
                    break;
                case "9":
                    System.out.println(" --------末尾插入元素-------");
                    ma.lastIndextArrray();
                    ma.printArray();
                    System.out.println(" ");
                case "10":
                    System.out.println(" --------删除线性表------");
                    ma.clearArray();
                    ma.printArray();
                    System.out.println(" ");
                    break;
                case "11":
                    System.out.println("------遍历线性表------");
                    ma.printArray();
                    System.out.println(" ");
                    break;
                case "12":
                    System.out.println("感谢您的使用");
                    System.exit(0);

                default:
                    System.out.println("功能选择错误，请重新选择！");

            }
        }
    }
}