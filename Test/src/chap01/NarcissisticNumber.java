package chap01;

import java.util.Scanner;

public class NarcissisticNumber {
    public static void main(String[] args) {
        //水仙花是指一个三位数，它的各位数字的立方和等于其本身
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //水仙花数为三位数
        if (num < 999) {
            int a = num % 10;
            int b = (num / 10) % 10;
            int c = num / 100;
            int sum = (a * a * a) + (b * b * b) + (c * c * c);
            if (num == sum) {
                System.out.println("该数为水仙花数");
            } else {
                System.out.println("该数不是水仙花数");
            }
        }
    }
}
