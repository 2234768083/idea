package view;

import javax.swing.*;

// 定义 StudentForm 类，用来显示窗体并处理用户的输入
public class StudentForm extends JFrame {
    // 定义需要的组件
    private JLabel nameLabel;
    private JTextField nameText;
    private JLabel ageLabel;
    private JTextField ageText;
    private JLabel studentIdLabel;
    private JTextField studentIdText;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton findButton;
    private JButton clearButton;
    private JTextArea resultArea;

    // 构造方法，用来创建 StudentForm 对象
    public StudentForm() {
        // 设置窗体标题
        this.setTitle("学生管理系统");
        // 设置窗体大小
        this.setSize(400, 300);
        // 设置窗体默认关闭操作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建组件
        this.nameLabel = new JLabel("姓名：");
        this.nameText = new JTextField(20);
        this.ageLabel = new JLabel("年龄：");
        this.ageText = new JTextField(20);
        this.studentIdLabel = new JLabel("学号：");
        this.studentIdText = new JTextField(20);
        this.addButton = new JButton("添加");
        this.updateButton = new JButton("修改");
        this.deleteButton = new JButton("删除");
        this.findButton = new JButton("查询");
        this.clearButton = new JButton("清空");
        this.resultArea = new JTextArea(10, 40);

        // 设置组件的布局
        JPanel panel = new JPanel();
        panel.add(this.nameLabel);
        panel.add(this.nameText);
        panel.add(this.ageLabel);
        panel.add(this.ageText);
        panel.add(this.studentIdLabel);
        panel.add(this.studentIdText);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(this.addButton);
        buttonPanel.add(this.updateButton);
        buttonPanel.add(this.deleteButton);
        buttonPanel.add(this.findButton);
        buttonPanel.add(this.clearButton);
        buttonPanel.add(this.resultArea);
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}
