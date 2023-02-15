package Handler;

import View.LoginView;
import View.MainView;
import View.RegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.*;
import java.nio.file.Files;

public class LoginHandler extends KeyAdapter implements ActionListener {

    private final LoginView loginView;
    public LoginHandler(LoginView loginView){
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton)e.getSource();
        String text = jButton.getText();
        if ("注册".equals(text)){
            RegisterView.cre();
            loginView.dispose();
        } else if ("登录".equals(text)) {
            try {
                login();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void login() throws IOException {
        String user = loginView.getUserText();
        char[] chars = loginView.getPwdField();
        String pwd = new String(chars);

        File fileIn = new File("src\\main\\java\\io\\AdUser.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(Files.newInputStream(fileIn.toPath()), "UTF-8"));
        boolean flag = false;
        String str = null;
        while ((str = in.readLine()) != null) {
            String user_r = str;
            str = in.readLine();
            if (user_r.equals(user) && str.equals(pwd)) {
                flag = true;
                break;
            }
            in.readLine();
        }

        if (flag) {
            MainView.cre();
            loginView.dispose();
        } else {
            JOptionPane.showMessageDialog(loginView, "用户名或密码错误");
        }
    }
}