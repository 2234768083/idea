package nuc.ss.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import nuc.ss.dao.UserService;
import nuc.ss.entity.User;

/**
 * @author 2113042703 王晰
 * @data
 * @description
 */
public class LoginFrame extends JFrame{
    private String username;
    private String password;

    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    private JButton btnOK;
    private JButton btnCancel;

    private JPanel panel, panel1, panel2, panel3;

    /**
     * 有参构造方法
     *
     * @param title
     */
    public LoginFrame(String title) {
        initGUI(); // 调用初始化图形用户界面方法
    }

    /**
     * 初始化图形用户界面方法
     */
    private void initGUI() {
        // 实例化组件（面板与控件）
        panel = (JPanel) getContentPane();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        lblUsername = new JLabel("用户名：");
        lblPassword = new JLabel("密    码：");
        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField(15);
        btnOK = new JButton("确定[O]");
        btnCancel = new JButton("取消[C]");

        // 将控件添加到三个小面板
        panel1.add(lblUsername);
        panel1.add(txtUsername);
        panel2.add(lblPassword);
        panel2.add(txtPassword);
        panel3.add(btnOK);
        panel3.add(btnCancel);

        // 设置主面板为三行一列的网格布局
        panel.setLayout(new GridLayout(3, 1));
        // 将三个小面板依次添加到主面板
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        // 设置按钮热键字母
        btnOK.setMnemonic(KeyEvent.VK_O);
        btnCancel.setMnemonic(KeyEvent.VK_C);
        // 设置密码框回显字符
        txtPassword.setEchoChar('*');

        // 设置窗口大小
        setSize(250, 200);
        // 设置窗口屏幕居中
        setLocationRelativeTo(null);
        // 设置窗口不可调整大小
        setResizable(false);
        // 设置窗口刚好容纳组件
        pack();
        // 设置窗口可见
        setVisible(true);
        // 设置窗口默认关闭操作
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void  eventsHandling() {
        // 给【确定】按钮注册监听器
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取用户输入的用户名和密码
                username = txtUsername.getText().trim();
                password = new String(txtPassword.getPassword());
                // 创建用户服务对象
                UserService userService = new UserService();
                // 调用服务对象的登录方法
                User user = userService.login(username, password);
                // 判断用户登录是否成功
                if (user != null) {
                    // 弹出消息框提示用户
                    JOptionPane.showMessageDialog(null, "恭喜，[" + username + "]登录成功~");
                    dispose(); // 关闭登录窗口
                    new AdministratorFrame();
                } else {
                    // 弹出消息框提示用户
                    JOptionPane.showMessageDialog(null, "遗憾，用户名或密码错误~");
                    // 清空两个文本框
                    txtUsername.setText("");
                    txtPassword.setText("");
                    // 让姓名文本框获取焦点
                    txtUsername.requestFocus();
                }
            }
        });

        // 给【取消】按钮注册监听器
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // 退出应用程序
            }
        });
    }

    public static void main(String[] args) {
        new LoginFrame("用户登录").eventsHandling();
    }

}

