package eneity;

// 定义 Student 类，用来存储学生的个人信息
class Student {
    // 学生的姓名
    private String name;
    // 学生的年龄
    private int age;
    // 学生的学号
    private int studentId;

    // 构造方法，用来创建 Student 对象
    public Student(String name, int age, int studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    // 获取学生的姓名
    public String getName() {
        return this.name;
    }

    // 获取学生的年龄
    public int getAge() {
        return this.age;
    }

    // 获取学生的学号
    public int getStudentId() {
        return this.studentId;
    }

    // 修改学生的姓名
    public void setName(String name) {
        this.name = name;
    }

    // 修改学生的年龄
    public void setAge(int age) {
        this.age = age;
    }

    // 打印学生的个人信息
    public void printInfo() {
        System.out.println("姓名：" + this.name);
        System.out.println("年龄：" + this.age);
        System.out.println("学号：" + this.studentId);
    }
}