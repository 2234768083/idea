package nuc.ss.shopping1.view;

import nuc.ss.shopping1.view.RegisterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JLabel l_name, l_type, l_password;

    private JTextField t_name;
    private JComboBox<String> c_type;
    private JPasswordField p_password;

    private JButton b_login, b_reset, b_register;

    public LoginFrame() {
        this.setSize(400,300);
        this.setTitle("电商购物-登录页面");
        this.setLocation(300,200);
        init();
        this.setVisible(true);
    }

    public void init() {
        l_name = new JLabel("用户名",JLabel.CENTER);
        l_type = new JLabel("用户类型",JLabel.CENTER);
        l_password = new JLabel("密码",JLabel.CENTER);

        t_name = new JTextField();
        c_type = new JComboBox<String>();
        c_type.addItem("管理员");
        c_type.addItem("普通用户");
        p_password = new JPasswordField();

        b_login = new JButton("登录");
        b_reset = new JButton("重置");
        b_register = new JButton("点我注册");

        b_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame();
            }
        });

        this.setLayout(null); // 自定义布局

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3,2,5,5));

        p.add(l_name);
        p.add(t_name);

        p.add(l_type);
        p.add(c_type);

        p.add(l_password);
        p.add(p_password);

        p.setBounds(5,5,385,185);

        this.add(p);

        p = new JPanel();
        p.setLayout(new GridLayout(1,3,5,5));
        p.add(b_login);
        p.add(b_reset);
        p.add(b_register);

        p.setBounds(5,195,375,60);

        this.add(p);

    }

    public static void main(String[] args) {
        new LoginFrame();
    }

}
