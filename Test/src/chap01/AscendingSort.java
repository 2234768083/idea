package chap01;

import java.util.Scanner;

public class AscendingSort {
    public static void main(String[] args) {
        // 将十个数存入数组中
        System.out.println("请输入10个数：");
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]=" + arr[i]);
        }

        // 定义一个循环控制
        for (int i = 0; i < arr.length - 1; i++) {
            // 定义一个循环控制每轮比较的次数
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 判断j当前位置的元素值 是否 大于后一个位置 若较大 则交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // 遍历数组内容输出
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
