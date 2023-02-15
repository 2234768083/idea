package chap01;

import java.util.Scanner;

public class TestTriplet {
    public static void main(String[] args) {
        // 1.使用类Triplet创建对象
        Triplet tri = new Triplet();
        while (true) {
            System.out.println("**********");
            System.out.println("请选择相应功能:");
            System.out.println("1.建立并输入三元组的三个数");
            System.out.println("2.取三元组的一个分量");
            System.out.println("3.置三元组的一个分量");
            System.out.println("4.三元组的最大分量");
            System.out.println("5.三元组的最小分量");
            System.out.println("6.显示三元组");
            System.out.println("7.销毁三元组");
            System.out.println("8.退出");
            System.out.println("**********");
            Scanner N = new Scanner(System.in);
            int number = N.nextInt();
            switch (number) {
                case 1:
                    tri.initTriplet();
                    break;
                case 2:
                    tri.getOne();
                    break;
                case 3:
                    tri.changeOne();
                    break;
                case 4:
                    tri.getMax();
                    break;
                case 5:
                    tri.getMin();
                    break;
                case 6:
                    tri.printTriplet();
                    break;
                case 7:
                    tri.destoryTriplet();
                    break;
                case 8:
                    return;
            }
        }
    }
}

// 定义一个三元组类Triplet
class Triplet {
    // 成员变量
    float e1, e2, e3;
    int N = 0;

    // 成员方法
    // 初始化三元组
    public void initTriplet() {
        // 从键盘接收三元组

        System.out.println("请输入N个实数:");
        for (int i = 0; i < N; i++) {
            Scanner sc = new Scanner(System.in);
            float N = sc.nextFloat();
        }
    }

    // 输出三元组:[23.4.45.6,67.8]
    public void printTriplet() {
        System.out.println("三元组为 : [" + e1 + ", " + e2 + ", " + e3 + "]");
    }

    //取三元组的一个分量
    public void getOne() {
        System.out.println("请输入要取第几个数:");
        Scanner number = new Scanner(System.in);
        int i = number.nextInt();
        switch (i) {
            case 1:
                System.out.println(e1);
                break;
            case 2:
                System.out.println(e2);
                break;
            case 3:
                System.out.println(e3);
                break;
        }
    }

    //置三元组的一个分量
    public void changeOne() {
        System.out.println("请输入要更改的数字序号:");
        Scanner b = new Scanner(System.in);
        int oldnumber = b.nextInt();
        System.out.println("请输入更改后的数字：");
        float newnumber = b.nextFloat();
        if (oldnumber == 1) {
            e1 = newnumber;
            return;
        }
        if (oldnumber == 2) {
            e2 = newnumber;
            return;
        }
        if (oldnumber == 3) {
            e3 = newnumber;
            return;
        }
    }

    // 求最大数
    public void getMax() {
        float max = e1;
        if (e2 > max) {
            max = e2;
        }
        if (e3 > max) {
            max = e3;
        }
        System.out.println("三个数中最大数是 : [" + max + "]");
    }

    // 求最小数
    public void getMin() {
        float min = e1;
        if (e2 < min) {
            min = e2;
        }
        if (e3 < min) {
            min = e3;
        }
        System.out.println("三个数中最小数是 : [" + min + "]");
    }

    public void destoryTriplet() {

    }
}

