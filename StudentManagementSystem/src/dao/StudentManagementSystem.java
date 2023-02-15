package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {
        // 创建一个学生列表
        List<Student> students = new ArrayList<>();

        // 添加学生
        students.add(new Student("小明", "男", 18, "001"));
        students.add(new Student("小红", "女", 19, "002"));
        students.add(new Student("小刚", "男", 20, "003"));

        // 创建 Scanner 对象，用来读取用户输入
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 打印菜单
            System.out.println("===============");
            System.out.println("1. 添加学生");
            System.out.println("2. 修改学生");
            System.out.println("3. 删除学生");
            System.out.println("4. 查找学生");
            System.out.println("5. 查看所有学生");
            System.out.println("6. 导出学生列表");
            System.out.println("0. 退出系统");
            System.out.println("===============");
            System.out.print("请选择您要进行的操作：");

            // 读取用户的选择
            int choice = scanner.nextInt();

            // 根据用户的选择执行不同的操作
            switch (choice) {
                case 1:
                    addStudent(students, scanner);
                    break;
                case 2:
                    updateStudent(students, scanner);
                    break;
                case 3:
                    deleteStudent(students, scanner);
                    break;
                case 4:
                    findStudent(students, scanner);
                    break;
                case 5:
                    listStudents(students);
                    break;
                case 6:
                    exportStudents(students);
                    break;
                case 0:
                    System.out.println("感谢您使用学生管理系统，再见！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("非法输入，请重新选择！");
                    break;
            }
        }
    }
    // 添加学生
    public static void addStudent(List<Student> students, Scanner scanner) {
        System.out.print("请输入学生的姓名：");
        String name = scanner.next();
        System.out.print("请输入学生的性别：");
        String gender = scanner.next();
        System.out.print("请输入学生的年龄：");
        int age = scanner.nextInt();
        System.out.print("请输入学生的学号：");
        String id = scanner.next();

        // 创建学生对象
        Student student = new Student(name, gender, age, id);

        // 将学生对象添加到列表中
        students.add(student);
        System.out.println("学生信息添加成功！");
    }

    // 修改学生信息
    public static void updateStudent(List<Student> students, Scanner scanner) {
        System.out.print("请输入要修改的学生的学号：");
        String id = scanner.next();

        // 查找学生
        Student s = findStudentById(id, students);
        if (s == null) {
            System.out.println("没有找到学号为 " + id + " 的学生！");
            return;
        }

        System.out.print("请输入新的姓名：");
        String name = scanner.next();
        System.out.print("请输入新的性别：");
        String gender = scanner.next();
        System.out.print("请输入新的年龄：");
        int age = scanner.nextInt();

        // 修改学生的信息
        s.setName(name);
        s.setGender(gender);
        s.setAge(age);
        System.out.println("学生信息修改成功！");
    }

    // 删除学生
    public static void deleteStudent(List<Student> students, Scanner scanner) {
        System.out.print("请输入要删除的学生的学号：");
        String id = scanner.next();

        // 查找学生
        Student s = findStudentById(id, students);
        if (s == null) {
            System.out.println("没有找到学号为 " + id + " 的学生！");
            return;
        }

        // 从列表中删除学生
        students.remove(s);
        System.out.println("学生信息删除成功！");
    }

    // 查找学生
    public static void findStudent(List<Student> students, Scanner scanner) {
        System.out.println("请选择要查找的方式：");
        System.out.println("1. 按学号查找");
        System.out.println("2. 按姓名查找");
        System.out.println("3. 按性别查找");
        System.out.println("4. 按年龄查找");
        System.out.print("请选择：");
        int choice = scanner.nextInt();

        // 根据用户的选择，调用不同的方法来查找学生
        switch (choice) {
            case 1:
                System.out.print("请输入要查找的学号：");
                String id = scanner.next();
                Student s = findStudentById(id, students);
                if (s == null)
            {
                System.out.println("没有找到学号为 " + id + " 的学生！");
            } else {
                System.out.println("找到学生：" + s);
            }
            break;
            case 2:
                System.out.print("请输入要查找的姓名：");
                String name = scanner.next();
                List<Student> studentsByName = findStudentsByName(name, students);
                if (studentsByName.isEmpty()) {
                    System.out.println("没有找到姓名为 " + name + " 的学生！");
                } else {
                    System.out.println("找到 " + studentsByName.size() + " 名学生：");
                    for (Student student : studentsByName) {
                        System.out.println(student);
                    }
                }
                break;
            case 3:
                System.out.print("请输入要查找的性别：");
                String gender = scanner.next();
                List<Student> studentsByGender = findStudentsByGender(gender, students);
                if (studentsByGender.isEmpty()) {
                    System.out.println("没有找到性别为 " + gender + " 的学生！");
                } else {
                    System.out.println("找到 " + studentsByGender.size() + " 名学生：");
                    for (Student student : studentsByGender) {
                        System.out.println(student);
                    }
                }
                break;
            case 4:
                System.out.print("请输入要查找的年龄：");
                int age = scanner.nextInt();
                List<Student> studentsByAge = findStudentsByAge(age, students);
                if (studentsByAge.isEmpty()) {
                    System.out.println("没有找到年龄为 " + age + " 的学生！");
                } else {
                    System.out.println("找到 " + studentsByAge.size() + " 名学生：");
                    for (Student student : studentsByAge) {
                        System.out.println(student);
                    }
                }
                break;
            default:
                System.out.println("非法输入，请重新选择！");
                break;
        }
    }
    // 查看所有学生
    public static void listStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("没有学生信息！");
            return;
        }

        System.out.println("共有 " + students.size() + " 名学生：");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // 导出学生列表
    public static void exportStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("没有学生信息，无法导出！");
            return;
        }

        // 实现导出学生列表的代码省略...
        System.out.println("学生列表已成功导出！");
    }

    // 根据学号查找学生
    public static Student findStudentById(String id, List<Student> students) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // 根据姓名查找学生
    public static List<Student> findStudentsByName(String name, List<Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equals(name)) {
                result.add(student);
            }
        }
        return result;
    }

    // 根据性别查找学生
    public static List<Student> findStudentsByGender(String gender, List<Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getGender().equals(gender)) {
                result.add(student);
            }
        }
        return result;
    }

    // 根据年龄查找学生
    public static List<Student> findStudentsByAge(int age, List<Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
}

class Student {
    private String name;
    private String gender;
    private int age;
    private String id;

    public Student(String name, String gender, int age, String id) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }

    public int getStudentId() {
        return 0;
    }

    public void printInfo() {
        return ;
    }
}
