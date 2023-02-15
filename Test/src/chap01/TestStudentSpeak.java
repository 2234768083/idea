/**
 * @ author yzy
 * @ date 2022.09.25
 * @ description  结合本章所学的重点知识（从键盘接收数据，数组，枚举类型），利用面向对象的思维，完成一个学生进行自我介绍的案例，在控制台输出，我的名字叫***，男/女，我上学期通过努力，取得了好成绩，各门功课的成绩如下：
 * （c语言85，高数89，线代87，思想道德与修养89）
 */
package chap01;

import java.util.Scanner;

// 主类
public class TestStudentSpeak {
    public static void main(String[] args) {

        Student s = new Student();
        s.init();
        s.speak();
        s.average();
    }
}

enum Sex {
    男, 女
}

class Student {
    String name;
    Sex sex;
    String[] course = {"数据结构与算法", "离散数学", "高等数学", "大学物理", "英语"};
    float[] score;
    float sum = 0;
    float average = 0;

    //初始化学生信息
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名、性别、各门功课的成绩；");
        System.out.println("姓名；");
        name = sc.next();
        System.out.println("性别；0代表男，1代表女");
        byte flag = sc.nextByte();
        if (flag == 0) {
            sex = Sex.男;
        } else {
            sex = Sex.女;
        }
        score = new float[course.length];
        for (int i = 0; i < course.length; i++) {
            System.out.println(course[i]);
            score[i] = sc.nextFloat();
        }
    }


    // 学生说话

    public void speak() {
        System.out.println("我的名字叫" + name + "," + sex + "，我上学期通过努力取得了好成绩，各门功课成绩如下；");
        for (int i = 0; i < course.length; i++) {
            System.out.print(course[i] + "");
            System.out.print(score[i] + ";");
        }
    }

    public void average() {
        for (int j = 0; j < score.length; j++) {
            sum = score[j] + sum;
            average = sum / 5;
        }
        System.out.println("平均数为" + average);
    }
}
