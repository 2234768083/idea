package View;

import Handler.LoginHandler;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class LoginView extends JFrame {
    JLabel namePanel = new JLabel("图书馆管理系统", SwingConstants.CENTER);
    SpringLayout springLayout = new SpringLayout();
    JPanel centerPanel = new JPanel(springLayout);
    private JPanel jp1 = new JPanel(new BorderLayout());
//    private JPanel jp2 = new jpl();
    JLabel userName = new JLabel("用户名：");
    JTextField userText = new JTextField();
    JLabel pwdPanel = new JLabel("密码：");
    JPasswordField pwdField = new JPasswordField();
    JButton loginBtn = new JButton("登录");
    JButton register = new JButton("注册");
    LoginHandler loginHandler;
    public LoginView() {
        super("图书馆管理系统");
        loginHandler = new LoginHandler(this);
        Container contentPane = getContentPane();

        //设置登录界面enter按钮为默认按钮
        getRootPane().setDefaultButton(loginBtn);

        //自定义程序图标
//        URL resource = LoginView.class.getClassLoader().getResource("ks.jpg");
//        assert resource != null;
//        Image image = new ImageIcon(resource).getImage();
//        setIconImage(image);

        //主JFrame界面左右JPanel布局
        contentPane.setLayout(new BorderLayout());
//        Color jp1_c = new Color(63, 151, 255);
        jp1.setBackground(Color.WHITE);
//        centerPanel.setBackground(Color.LIGHT_GRAY);
        jp1.setPreferredSize(new Dimension(600, 0));
//        jp2.setPreferredSize(new Dimension(600, 0));
        contentPane.add(jp1, BorderLayout.EAST);
//        contentPane.add(jp2, BorderLayout.WEST);

        //jp2中的按钮布局
        namePanel.setFont(new Font("楷体", Font.PLAIN, 80));
        namePanel.setSize(new Dimension(0, 100));

        Font jp1Font = new Font("楷体", Font.PLAIN, 30);
        userName.setFont(jp1Font);
        userText.setPreferredSize(new Dimension(200, 40));
        pwdPanel.setFont(jp1Font);
        pwdField.setPreferredSize(new Dimension(200, 40));
        loginBtn.setFont(jp1Font);
        register.setFont(jp1Font);

        register.setContentAreaFilled(false);
        loginBtn.setContentAreaFilled(false);

        centerPanel.add(userName);
        centerPanel.add(userText);
        centerPanel.add(pwdPanel);
        centerPanel.add(pwdField);
        loginBtn.addActionListener(loginHandler);
        loginBtn.addKeyListener(loginHandler);
        centerPanel.add(loginBtn);
        register.addActionListener(loginHandler);
        centerPanel.add(register);
        centerPanel.setBackground(Color.WHITE);
        //弹簧布局
        layoutJp1();

        jp1.add(namePanel, BorderLayout.NORTH);
        jp1.add(centerPanel, BorderLayout.CENTER);


        setSize(600, 450);
        setBackground(Color.BLUE);
        setLocationRelativeTo(null);//居中显示
        setResizable(false);//大小不可以改变
        setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭结束程序
        setVisible(true);
    }

    public void layoutJp1() {
        Spring childWidth = Spring.sum(Spring.sum(Spring.width(userName), Spring.width(userText)), Spring.constant(20));
        int offsetX = childWidth.getValue() / 2;
        springLayout.putConstraint(SpringLayout.WEST, userName, -offsetX - 10, SpringLayout.HORIZONTAL_CENTER, jp1);
        springLayout.putConstraint(SpringLayout.NORTH, userName, 50, SpringLayout.NORTH, jp1);

        //userText
        springLayout.putConstraint(SpringLayout.WEST, userText, 10, SpringLayout.EAST, userName);
        springLayout.putConstraint(SpringLayout.NORTH, userText, 0, SpringLayout.NORTH, userName);

        //pwdLable
        springLayout.putConstraint(SpringLayout.NORTH, pwdPanel, 20, SpringLayout.SOUTH, userName);
        springLayout.putConstraint(SpringLayout.EAST, pwdPanel,0, SpringLayout.EAST, userName);

        //pwdText
        springLayout.putConstraint(SpringLayout.WEST, pwdField, 10, SpringLayout.EAST, pwdPanel);
        springLayout.putConstraint(SpringLayout.NORTH, pwdField, 0, SpringLayout.NORTH, pwdPanel);

        //loginBtn
        springLayout.putConstraint(SpringLayout.NORTH, loginBtn, 60, SpringLayout.SOUTH, pwdPanel);
        springLayout.putConstraint(SpringLayout.EAST, loginBtn, 0, SpringLayout.EAST, userName);

        //register
        springLayout.putConstraint(SpringLayout.NORTH, register, 0, SpringLayout.NORTH, loginBtn);
        springLayout.putConstraint(SpringLayout.EAST, register, -15, SpringLayout.EAST, pwdField);
    }

    public static void main(String[] args) {
        new LoginView();
    }

    public String getUserText() {
        return userText.getText();
    }

    public char[] getPwdField() {
        return pwdField.getPassword();
    }
}
