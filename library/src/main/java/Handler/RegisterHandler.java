package Handler;

import View.LoginView;
import View.RegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.*;
import java.nio.file.Files;

public class RegisterHandler extends KeyAdapter implements ActionListener {
    private final RegisterView registerView;

    public RegisterHandler(RegisterView registerView) {
        this.registerView = registerView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton)e.getSource();
        String text = jButton.getText();
        if ("注册".equals(text)) {
            try {
                register();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }else if ("取消".equals(text)) {
            new LoginView();
            RegisterView.shutDown();
        }
    }

    public void register() throws IOException {
        String userName = registerView.getUserText();
        char[] s1 = registerView.getPwdField();
        char[] s2 = registerView.getRPwdField();
        String pwd = new String(s1);
        String rPwd = new String(s2);

        if (pwd.equals("") || userName.equals("")) {
            JOptionPane.showMessageDialog(registerView, "请将信息填写完整");
        } else if (!pwd.equals(rPwd)) {
            JOptionPane.showMessageDialog(registerView, "俩次输入密码不一致");
        } else if (check(userName)) {
            JOptionPane.showMessageDialog(registerView, "用户名已存在");
        } else {
            FileWriter fw = new FileWriter("src\\main\\java\\io\\AdUser.txt",true);
            fw.append("\n");
            fw.append("\n");
            fw.append(userName);
            fw.append("\n");
            fw.append(pwd);
            fw.close();

            JOptionPane.showMessageDialog(registerView, "注册成功,返回登录界面登录");
            new LoginView();
            RegisterView.shutDown();
        }
    }

    public boolean check(String userName) throws IOException {
        File fileIn = new File("src\\main\\java\\io\\AdUser.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(Files.newInputStream(fileIn.toPath()), "UTF-8"));
        boolean flag = false;
        String str = null;
        while ((str = in.readLine()) != null) {
            String user_r = str;
            str = in.readLine();
            if (user_r.equals(userName)) {
                return true;
            }
            in.readLine();
        }
        return false;
    }
}
