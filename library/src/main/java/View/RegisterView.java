package View;

import Handler.RegisterHandler;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame {
    SpringLayout springLayout = new SpringLayout();
    JPanel centerPanel = new JPanel(springLayout);
    JPanel jp = new JPanel(new BorderLayout());
//    JLabel namePanel = new JLabel("注册", SwingConstants.CENTER);
    JLabel userName = new JLabel("用户名:");
    JTextField userText = new JTextField();
    JLabel pwdPanel = new JLabel("密码:");
    JPasswordField pwdField = new JPasswordField();
    JLabel rPwdPanel = new JLabel("再次确认:");
    JPasswordField rPwdField = new JPasswordField();
    JButton register = new JButton("注册");
    JButton cancel = new JButton("取消");
    RegisterHandler registerHandler;
    static RegisterView registerView;
    public RegisterView() {
        super("图书馆管理系统");
        registerHandler = new RegisterHandler(this);
        Container contentPane = getContentPane();

        //自定义程序图标
//        URL resource = MainView.class.getClassLoader().getResource("ks.jpg");
//        assert resource != null;
//        Image image = new ImageIcon(resource).getImage();
//        setIconImage(image);

        contentPane.setLayout(new BorderLayout());
        jp.setBackground(Color.WHITE);

        contentPane.add(jp, BorderLayout.CENTER);


//        namePanel.setFont(new Font("华文行楷", Font.PLAIN, 80));
//        namePanel.setSize(new Dimension(0, 100));
        Font jpFont = new Font("楷体", Font.PLAIN, 30);
        userName.setFont(jpFont);
        userText.setPreferredSize(new Dimension(200, 40));
        pwdPanel.setFont(jpFont);
        pwdField.setPreferredSize(new Dimension(200, 40));
        rPwdPanel.setFont(jpFont);
        rPwdField.setPreferredSize(new Dimension(200, 40));
        register.setFont(jpFont);
        cancel.setFont(jpFont);

        register.setContentAreaFilled(false);
        cancel.setContentAreaFilled(false);

        centerPanel.add(userName);
        centerPanel.add(userText);
        centerPanel.add(pwdPanel);
        centerPanel.add(pwdField);
        centerPanel.add(rPwdPanel);
        centerPanel.add(rPwdField);
        centerPanel.add(register);
        centerPanel.setBackground(Color.WHITE);
        register.addActionListener(registerHandler);
        centerPanel.add(cancel);
        cancel.addActionListener(registerHandler);

        layoutJp();

//        jp.add(namePanel, BorderLayout.NORTH);
        jp.add(centerPanel, BorderLayout.CENTER);

        setSize(500, 400);
        setBackground(Color.WHITE);
//        setUndecorated (true);//设置当前JFrame窗口无边框
        setLocationRelativeTo(null);//居中显示
        setResizable(false);//设置大小不可改变
        setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭结束程序
        setVisible(true);
    }

    private void layoutJp() {
        Spring childWidth = Spring.sum(Spring.sum(Spring.width(userName), Spring.width(userText)), Spring.constant(20));
        int offsetX = childWidth.getValue() / 2;
        //userName
        springLayout.putConstraint(SpringLayout.WEST, userName, -offsetX - 10, SpringLayout.HORIZONTAL_CENTER, centerPanel);
        springLayout.putConstraint(SpringLayout.NORTH, userName, 50, SpringLayout.NORTH, centerPanel);

        //userText
        springLayout.putConstraint(SpringLayout.WEST, userText, 30, SpringLayout.EAST, userName);
        springLayout.putConstraint(SpringLayout.NORTH, userText, 0, SpringLayout.NORTH, userName);

        //pwdPanel
        springLayout.putConstraint(SpringLayout.EAST, pwdPanel, 0, SpringLayout.EAST, userName);
        springLayout.putConstraint(SpringLayout.NORTH, pwdPanel, 40, SpringLayout.SOUTH, userName);

        //rPwdPanel
        springLayout.putConstraint(SpringLayout.EAST, rPwdPanel, 25, SpringLayout.EAST, pwdPanel);
        springLayout.putConstraint(SpringLayout.NORTH, rPwdPanel, 40, SpringLayout.SOUTH, pwdPanel);

        //pwdFiled
        springLayout.putConstraint(SpringLayout.EAST, pwdField, 0, SpringLayout.EAST, userText);
        springLayout.putConstraint(SpringLayout.NORTH, pwdField, 0, SpringLayout.NORTH, pwdPanel);

        //rPwdFiled
        springLayout.putConstraint(SpringLayout.WEST, rPwdField, 0, SpringLayout.WEST, pwdField);
        springLayout.putConstraint(SpringLayout.NORTH, rPwdField, 0, SpringLayout.NORTH, rPwdPanel);

        //register
        springLayout.putConstraint(SpringLayout.EAST, register, 0, SpringLayout.EAST, rPwdPanel);
        springLayout.putConstraint(SpringLayout.NORTH, register, 55, SpringLayout.SOUTH, rPwdPanel);

        //cancel
        springLayout.putConstraint(SpringLayout.NORTH, cancel, 0, SpringLayout.NORTH, register);
        springLayout.putConstraint(SpringLayout.EAST, cancel, -15, SpringLayout.EAST, rPwdField);
    }

    public static void cre() {
        registerView = new RegisterView();
    }

    public static void shutDown() {
        registerView.dispose();
    }

    public String getUserText() {
        return userText.getText();
    }

    public char[] getPwdField() {
        return pwdField.getPassword();
    }

    public char[] getRPwdField() {
        return rPwdField.getPassword();
    }
}
