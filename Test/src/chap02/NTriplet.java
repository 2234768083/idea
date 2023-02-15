package chap02;

import java.util.Scanner;

public class NTriplet {
    public static void main(String[] args) {
        Tuple tri = new Tuple();
        tri.menu();
        Scanner k = new Scanner(System.in);
        while (true) {

            int key = k.nextInt();
            switch (key) {

                case 0:
                    tri.menu();
                    break;
                case 1:
                    tri.initTuple();
                    break;
                case 2:
                    tri.PrintTuple();
                    break;
                case 3:
                    tri.GetNUM();
                    break;
                case 4:
                    tri.Change();
                    break;
                case 5:
                    tri.GetMax();
                    break;
                case 6:
                    tri.GetMin();
                    break;
                case 7:
                    return;
            }

        }
    }
}

class Tuple {
    int n, e;
    float[] num;
    Scanner k = new Scanner(System.in);

    public void menu() {
        System.out.println("******************");
        System.out.println("*0:显示菜单：*");
        System.out.println("*1：初始化N元组-输入数据：*");
        System.out.println("*2：显示N元组的数据：*");
        System.out.println("*3：取出N元组的某个元素：*");
        System.out.println("*4：置换N元组的某个元素：*");
        System.out.println("*5：取N元组的最大值：*");
        System.out.println("*6：取N元组的最小值：*");
        System.out.println("*7：退出程序：");
        System.out.println("******************");

    }

    //输入数据5
    public void initTuple() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入N");
        n = sc.nextInt();
        num = new float[n];
        for (int i = 0; i < n; i++) {
            e = i + 1;
            System.out.println("请输入" + e + "个数字");
            num[i] = sc.nextFloat();
        }
    }

    public void PrintTuple() {
        for (int a = 0; a < n; a++) {
            System.out.println("第" + a + "个数字是" + num[a]);
        }
    }

    public void GetNUM() {
        System.out.println("输入要获取的数字序号");
        int w = k.nextInt();
        for (int i = 0; i < n; i++) {
            if ((w - 1) == i) System.out.println(num[i]);
        }
    }

    public void Change() {
        System.out.println("输入要替换的数字序号");
        int q = k.nextInt();
        for (int i = 0; i < n; i++) {
            if ((q - 1) == i) {
                System.out.println("输入改变后的数字");
                float m = k.nextFloat();
                num[i] = m;
            }
        }
    }

    public void GetMax() {
        float max;
        max = num[0];
        for (int i = 1; i < n; i++) {
            if (num[i] > num[0]) {
                max = num[i];
            }

        }
        System.out.println("最大值是" + max);
    }

    public void GetMin() {
        float min;
        min = num[0];
        for (int i = 1; i < n; i++) {
            if (num[i] < num[0]) {
                min = num[i];
            }

        }
        System.out.println("最小值是" + min);
    }

}
