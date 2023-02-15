//package Handler;
//
//import View.AdminView;
//import View.LoginView;
//import View.MainView;
//import View.RegisterView;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//
//public class AdminHandler extends KeyAdapter implements ActionListener {
//    private final AdminView adminView;
//
//    public AdminHandler(AdminView adminView) {
//        this.adminView = adminView;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        JButton jButton = (JButton)e.getSource();
//        String text = jButton.getText();
//        if ("登录".equals(text)) {
//            System.out.println("请填写信息");
//        }else if ("退出".equals(text)) {
//            new LoginView();
//            adminView.dispose();
//        }
//    }
//}
