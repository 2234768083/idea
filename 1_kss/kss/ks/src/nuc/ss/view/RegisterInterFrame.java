package nuc.ss.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author 2113042703 王晰
 * @data
 * @description
 */
public class RegisterInterFrame extends JFrame {
    private JLabel account, name, password, confirmpass, sex, city, type;
    private JTextField t_account, t_name;
    private JButton regedit, reset;
    private JPasswordField t_password, t_confirmspass;
    private JRadioButton t_sex1, t_sex2;

    private JComboBox t_city, c_type;

    public RegisterInterFrame() {
        this.setTitle("车辆管理系统注册平台");
        this.setSize(300, 450);
        this.setLocation(300, 300);
        init();
        this.setVisible(true);
    }

    public void init() {
        this.setLayout(new GridLayout(8, 2, 5, 5));
        account = new JLabel("账号", SwingConstants.CENTER);
        this.add(account);
        t_account = new JTextField();
        this.add(t_account);
        name = new JLabel("姓名", SwingConstants.CENTER);
        this.add(name);
        t_name = new JTextField();
        this.add(t_name);
        password = new JLabel("密码", SwingConstants.CENTER);
        t_password = new JPasswordField();
        this.add(password);
        this.add(t_password);
        confirmpass = new JLabel("确认密码", SwingConstants.CENTER);
        t_confirmspass = new JPasswordField();
        this.add(confirmpass);
        this.add(t_confirmspass);
        type = new JLabel("用户类型", SwingConstants.CENTER);
        this.add(type);
        c_type = new JComboBox<String>();
        c_type.addItem("管理员");
        c_type.addItem("普通用户");
        this.add(c_type);
        sex = new JLabel("性别", SwingConstants.CENTER);
        this.add(sex);
        JPanel J = new JPanel();
        t_sex1 = new JRadioButton("男");
        t_sex2 = new JRadioButton("女");
        J.add(t_sex1);
        J.add(t_sex2);
        this.add(J);
        city = new JLabel("城市", SwingConstants.CENTER);
        this.add(city);
        t_city = new JComboBox<String>();
        t_city.addItem("长治");
        t_city.addItem("太原");
        t_city.addItem("运城");
        t_city.addItem("大同");
        this.add(t_city);
        regedit = new JButton("注册");
        this.add(regedit);
        regedit.addActionListener(e -> initdata());

        reset = new JButton("重置");
        this.add(reset);
    }

    public void initdata() {
        String id = t_account.getText().trim();
        String name = t_name.getText().trim();
        String type = (String) c_type.getSelectedItem();
        char sex;
        if (t_sex1.isSelected()) {
            sex = '男';
        } else {
            sex = '女';
        }
        String city = (String) t_city.getSelectedItem();
        if (new String(t_password.getPassword()).equals(new String(t_confirmspass.getPassword()))) {
            String password = new String(t_password.getPassword());
            JOptionPane.showMessageDialog(this, "注册成功！请登录。", "提示", JOptionPane.CLOSED_OPTION);
        } else {
            JOptionPane.showMessageDialog(this, "前后输入密码不一致！请重新输入。", "警告对话框", JOptionPane.WARNING_MESSAGE);
            t_password.setText("");
            t_confirmspass.setText("");
        }
    }

    public static void main(String[] args) {
        new RegisterInterFrame();
    }
}

