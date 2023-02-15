package dao;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


// 定义 StudentManager 类，用来管理学生信息
public class StudentManager {
    // 存储学生信息的 List
    private List<Student> students;

    // 构造方法，用来创建 StudentManager 对象
    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // 添加学生
    public void addStudent(Student student) {
        this.students.add(student);
    }

    // 根据学号查询学生
    public Student findStudentById(int studentId) {
        for (Student student : this.students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    // 根据学号删除学生
    public void removeStudentById(int studentId) {
        for (Student student : this.students) {
            if (student.getStudentId() == studentId) {
                this.students.remove(student);
                break;
            }
        }
    }

    // 修改学生信息
    public void updateStudent(Student student) {
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getStudentId() == student.getStudentId()) {
                this.students.set(i, student);
                break;
            }
        }
    }

    // 打印所有学生的信息
    public void printAllStudents() {
        for (Student student : this.students) {
            student.printInfo();
            System.out.println("-------------------");
        }
    }
}