package Handler;

import View.LoginView;
import View.MainView;
import View.AddView;
import View.UpdateView;
import View.DelView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class MainHandler extends KeyAdapter implements ActionListener {
    MainView mainView;
    public MainHandler(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton)e.getSource();
        String text = jButton.getText();
        if ("退出".equals(text)) {
            MainView.shutDown();
            new LoginView();
        } else if ("添加".equals(text)) {
            add();
        } else if ("修改".equals(text)) {
            update();
        } else if ("删除".equals(text)) {
            del();
        }
    }

    private void add() {
        AddView.cre();
    }
    private void update() {
        UpdateView.cre();
    }
    private void del() {
        DelView.cre();
    }
}
