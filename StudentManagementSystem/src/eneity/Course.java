package eneity;

// 定义 Course 类，用来存储课程信息
public class Course {
    // 课程名称
    private String name;
    // 教师姓名
    private String teacher;
    // 学分
    private int credit;

    // 构造方法，用来创建 Course 对象
    public Course(String name, String teacher, int credit) {
        this.name = name;
        this.teacher = teacher;
        this.credit = credit;
    }

    // 获取课程名称
    public String getName() {
        return this.name;
    }

    // 获取教师姓名
    public String getTeacher() {
        return this.teacher;
    }

    // 获取学分
    public int getCredit() {
        return this.credit;
    }

    // 修改课程名称
    public void setName(String name) {
        this.name = name;
    }

    // 修改教师姓名
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    // 修改学分
    public void setCredit(int credit) {
        this.credit = credit;
    }

    // 打印课程信息
    public void printInfo() {
        System.out.println("课程名称：" + this.name);
        System.out.println("教师姓名：" + this.teacher);
        System.out.println("学分：" + this.credit);
    }
}
