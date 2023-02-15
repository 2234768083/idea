package View;

import Handler.DelHandler;

import javax.swing.*;
import java.awt.*;

public class DelView extends JFrame {
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);
    JLabel id = new JLabel("图书编号:");
    static JTextField idText = new JTextField();
    JButton add = new JButton("确认删除");
    JButton cancel = new JButton("取消");
    DelHandler delHandler;
    static DelView delView;
    public DelView() {
        super("图书馆管理系统");
        delHandler = new DelHandler(this);
        Container contentPane = getContentPane();

        setUndecorated(true);

        contentPane.add(jPanel);

//        URL resource = LoginView.class.getClassLoader().getResource("ks.jpg");
//        assert resource != null;
//        Image image = new ImageIcon(resource).getImage();
//        setIconImage(image);

        Font jp1Font = new Font("楷体", Font.PLAIN, 30);
        id.setFont(jp1Font);
        add.setFont(jp1Font);
        cancel.setFont(jp1Font);
        idText.setPreferredSize(new Dimension(80, 40));

        add.setContentAreaFilled(false);
        cancel.setContentAreaFilled(false);

        jPanel.setBackground(Color.LIGHT_GRAY);

        jPanel.add(id);
        jPanel.add(idText);
        jPanel.add(add);
        add.addActionListener(delHandler);
        jPanel.add(cancel);
        cancel.addActionListener(delHandler);

        delLayout();

        setSize(500, 200);
        setLocationRelativeTo(null);//居中显示
        setResizable(false);//大小不可以改变
        setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭结束程序
        setVisible(true);
    }

    public void delLayout() {
        Spring childWidth = Spring.sum(Spring.sum(Spring.width(id), Spring.width(idText)), Spring.constant(20));
        int offsetX = childWidth.getValue() / 2;

        springLayout.putConstraint(SpringLayout.EAST, id, -offsetX + 120, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, id, 30, SpringLayout.NORTH, jPanel);

        springLayout.putConstraint(SpringLayout.WEST, idText, 50, SpringLayout.EAST, id);
        springLayout.putConstraint(SpringLayout.NORTH, idText, 0, SpringLayout.NORTH, id);

        springLayout.putConstraint(SpringLayout.NORTH, add, 30, SpringLayout.SOUTH, id);
        springLayout.putConstraint(SpringLayout.WEST, add, -20, SpringLayout.WEST, id);

        springLayout.putConstraint(SpringLayout.NORTH, cancel, 0, SpringLayout.NORTH, add);
        springLayout.putConstraint(SpringLayout.WEST, cancel, 40, SpringLayout.EAST, add);
    }

    public static void cre() {
        delView = new DelView();
    }
    public static void shutDown() {
        delView.dispose();
    }
    public static String getIdText() {
        return idText.getText();
    }
}