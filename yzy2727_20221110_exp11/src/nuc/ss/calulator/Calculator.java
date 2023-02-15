package nuc.ss.calulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JLabel l_num1, l_op, l_num2, l_result;
    private JTextField t_num1, t_op, t_num2, t_result;
    private JButton b_cal, b_reset;

    public Calculator() {
        this.setTitle("简易计算器");
        this.setSize(300, 400);
        this.setLocation(400, 200);
        init();
        this.setVisible(true);
    }

    /**
     * 初始化窗体中的组件并将这些组件放入窗体
     */
    public void init() {
        l_num1 = new JLabel("操作数1", JLabel.CENTER);
        l_op = new JLabel("运算符", JLabel.CENTER);
        l_num2 = new JLabel("操作数2", JLabel.CENTER);
        l_result = new JLabel("结果", JLabel.CENTER);

        t_num1 = new JTextField();
        t_op = new JTextField();
        t_num2 = new JTextField();
        t_result = new JTextField();

        b_cal = new JButton("计算");

        // 在计算按钮上注册动作监听器

        b_cal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            cal();
            }
        });

        b_reset = new JButton("重置");
        b_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t_num1.setText("");
                t_op.setText("");
                t_num2.setText("");
                t_result.setText("");
            }
        });
        // 添加组件之前首先设置窗体的布局为网格布局
        this.setLayout(new GridLayout(5, 2));

        this.add(l_num1);
        this.add(t_num1);

        this.add(l_op);
        this.add(t_op);

        this.add(l_num2);
        this.add(t_num2);

        this.add(l_result);
        this.add(t_result);

        this.add(b_cal);
        this.add(b_reset);
    }

    public void cal() {
        // 从窗体接收操作数和运算符
        float num1 = Float.valueOf(t_num1.getText());
        char op = t_op.getText().charAt(0);
        float num2 = Float.valueOf(t_num2.getText());
        float result;
        switch (op) {
            case '+':
                t_result.setText("" + (num1 + num2));
                break;
            case '-':
                t_result.setText("" + (num1 - num2));
                break;
            case '*':
                t_result.setText("" + (num1 * num2));
                break;
            case '/':
                t_result.setText("" + (num1 / num2));
                break;
            default:
                JOptionPane.showMessageDialog(this, "您输入了非法的运算符", "警告对话框", JOptionPane.WARNING_MESSAGE);
                t_op.setText("");
        }


    }
}
