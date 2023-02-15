package nuc.ss.shopping1.view;

import nuc.ss.shopping1.entity.User;

import javax.swing.*;

public class UserInfoFrame extends JFrame {
    private JTable t_user;

    public UserInfoFrame(User u){
        this.setTitle("电商购物-注册用户信息");
        this.setSize(500,400);
        this.setLocation(1000,200);
        init(u);
        this.setVisible(true);
    }


    public void init(User u){
        t_user = new JTable();
        Object[] t_title = {"用户名","姓名","密码","性别","城市"};

        Object[][] users = {{u.getId(), u.getName(), u.getPassword(), u.getSex(), u.getCity()}};

        t_user = new JTable(users , t_title);

        this.add(new JScrollPane(t_user));
    }

}
