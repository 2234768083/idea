//package View;
//
//import Handler.AdminHandler;
//import Handler.RegisterHandler;
//
//import javax.swing.*;
//import java.awt.*;
//import java.net.URL;
//
//public class AdminView extends JFrame {
//    SpringLayout springLayout = new SpringLayout();
//    JPanel centerPanel = new JPanel(springLayout);
//    JPanel jp = new JPanel(new BorderLayout());
//    JLabel namePanel = new JLabel("管理员登录", SwingConstants.CENTER);
//    JLabel userName = new JLabel("用户名:");
//    JTextField userText = new JTextField();
//    JLabel pwdPanel = new JLabel("密码:");
//    JPasswordField pwdField = new JPasswordField();
//    JButton register = new JButton("登录");
//    JButton cancel = new JButton("退出");
//    JButton back = new JButton("返回主界面");
//    AdminHandler adminHandler;
//    public AdminView() {
//        super("租车管理系统");
//        adminHandler = new AdminHandler(this);
//        Container contentPane = getContentPane();
//
//        //自定义程序图标
//        URL resource = MainView.class.getClassLoader().getResource("ks.jpg");
//        assert resource != null;
//        Image image = new ImageIcon(resource).getImage();
//        setIconImage(image);
//
//        contentPane.setLayout(new BorderLayout());
//        jp.setBackground(Color.LIGHT_GRAY);
//
//        contentPane.add(jp, BorderLayout.CENTER);
//
//        namePanel.setFont(new Font("华文行楷", Font.PLAIN, 60));
//        namePanel.setSize(new Dimension(0, 100));
//        Font jpFont = new Font("楷体", Font.PLAIN, 30);
//        userName.setFont(jpFont);
//        userText.setPreferredSize(new Dimension(200, 40));
//        pwdPanel.setFont(jpFont);
//        pwdField.setPreferredSize(new Dimension(200, 40));
//        register.setFont(jpFont);
//        cancel.setFont(jpFont);
//
//        register.setContentAreaFilled(false);
//        cancel.setContentAreaFilled(false);
//
//        centerPanel.add(userName);
//        centerPanel.add(userText);
//        centerPanel.add(pwdPanel);
//        centerPanel.add(pwdField);
//        centerPanel.add(register);
//        register.addActionListener(adminHandler);
//        centerPanel.add(cancel);
//        cancel.addActionListener(adminHandler);
//
//        layoutJp();
//
//        jp.add(namePanel, BorderLayout.NORTH);
//        jp.add(centerPanel, BorderLayout.CENTER);
//
//        setSize(400, 600);
//        setBackground(Color.LIGHT_GRAY);
////        setUndecorated (true);//设置当前JFrame窗口无边框
//        setLocationRelativeTo(null);//居中显示
//        setResizable(false);//设置大小不可改变
//        setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭结束程序
//        setVisible(true);
//    }
//
//    private void layoutJp() {
//        Spring childWidth = Spring.sum(Spring.sum(Spring.width(userName), Spring.width(userText)), Spring.constant(20));
//        int offsetX = childWidth.getValue() / 2;
//        //userName
//        springLayout.putConstraint(SpringLayout.WEST, userName, -offsetX - 10, SpringLayout.HORIZONTAL_CENTER, centerPanel);
//        springLayout.putConstraint(SpringLayout.NORTH, userName, 100, SpringLayout.NORTH, centerPanel);
//
//        //userText
//        springLayout.putConstraint(SpringLayout.WEST, userText, 30, SpringLayout.EAST, userName);
//        springLayout.putConstraint(SpringLayout.NORTH, userText, 0, SpringLayout.NORTH, userName);
//
//        //pwdPanel
//        springLayout.putConstraint(SpringLayout.EAST, pwdPanel, 0, SpringLayout.EAST, userName);
//        springLayout.putConstraint(SpringLayout.NORTH, pwdPanel, 40, SpringLayout.SOUTH, userName);
//
//        //pwdFiled
//        springLayout.putConstraint(SpringLayout.EAST, pwdField, 0, SpringLayout.EAST, userText);
//        springLayout.putConstraint(SpringLayout.NORTH, pwdField, 0, SpringLayout.NORTH, pwdPanel);
//
//        //register
//        springLayout.putConstraint(SpringLayout.EAST, register, 0, SpringLayout.EAST, pwdPanel);
//        springLayout.putConstraint(SpringLayout.NORTH, register, 55, SpringLayout.SOUTH, pwdPanel);
//
//        //cancel
//        springLayout.putConstraint(SpringLayout.NORTH, cancel, 0, SpringLayout.NORTH, register);
//        springLayout.putConstraint(SpringLayout.EAST, cancel, -15, SpringLayout.EAST, pwdField);
//    }
//
//    public static void main(String[] args) {
//        new AdminView();
//    }
//}
