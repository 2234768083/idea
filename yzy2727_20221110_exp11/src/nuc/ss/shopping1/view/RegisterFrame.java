package nuc.ss.shopping1.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import nuc.ss.shopping1.entity.User;



public class RegisterFrame extends JFrame{
    JLabel l_id, l_name, l_password1, l_password2, l_role ,l_sex, l_city;
    JTextField t_id, t_name;
    JPasswordField p_password1, p_password2;
    JComboBox<String> c_role;

    ButtonGroup gp;
    JRadioButton r_boy, r_girl;

    JComboBox<String> c_city;
    JButton btn_reset, btn_register;
    public RegisterFrame(){
        setTitle("电商购物-注册页面");
        setSize(300, 400);
        setLocation(700, 200);
        init();
        setVisible(true);
    }
    void init(){
        l_id = new JLabel("账号", JLabel.CENTER);
        l_name = new JLabel("姓名", JLabel.CENTER);
        l_password1 = new JLabel("密码", JLabel.CENTER);
        l_password2 = new JLabel("确认密码", JLabel.CENTER);
        l_role = new JLabel("用户类型", JLabel.CENTER);
        l_sex = new JLabel("性别", JLabel.CENTER);
        l_city = new JLabel("城市", JLabel.CENTER);

        t_id = new JTextField();
        t_name = new JTextField();
        p_password1 = new JPasswordField();
        p_password2 = new JPasswordField();
        c_role = new JComboBox<String>();
        c_role.addItem("管理员");
        c_role.addItem("普通用户");

        gp = new ButtonGroup();
        r_boy = new JRadioButton("男");
        r_girl = new JRadioButton("女");

        gp.add(r_boy);
        gp.add(r_girl);

        c_city = new JComboBox();
        c_city.addItem("̫太原");
        c_city.addItem("北京");
        c_city.addItem("上海");
        c_city.addItem("天津");
        c_city.addItem("重庆");
        btn_reset = new JButton("重置");
        btn_register = new JButton("注册");

        btn_register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String id = t_id.getText().trim();
                String name = t_name.getText().trim();
                String type = (String)c_role.getSelectedItem();
                char sex;
                String password = null;

                if(r_boy.isSelected()){
                    sex = '男';
                }else{
                    sex = '女';
                }
                String city = (String)c_city.getSelectedItem();
                if((new String(p_password1.getPassword())).equals(new String(p_password2.getPassword()))){
                    password = new String(p_password1.getPassword());
                    User user = new User(id, name, password,type, sex,city);
                    new UserInfoFrame(user);
                }else{
                    showMessage();

                }


            }

        });

        this.setLayout(new GridLayout(8,2,5,5));
        add(l_id);
        add(t_id);
        add(l_name);
        add(t_name);
        add(l_password1);
        add(p_password1);
        add(l_password2);
        add(p_password2);
        add(l_role);
        add(c_role);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2, 5, 5));
        p.add(r_boy);
        p.add(r_girl);

        add(l_sex);
        add(p);

        add(l_city);
        add(c_city);

        add(btn_reset);
        add(btn_register);

    }

    public void showMessage(){
        JOptionPane.showMessageDialog(this, "两次输入的密码不一样！");

        p_password1.setText("");
        p_password2.setText("");
    }


}
