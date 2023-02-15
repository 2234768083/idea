package View;

import Handler.AddHandler;

import javax.swing.*;
import java.awt.*;

public class AddView extends JFrame {
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);

    JLabel id = new JLabel("编号:");
    JLabel item = new JLabel("书籍名:");
    JLabel peo = new JLabel("销售店铺:");
    JLabel ip = new JLabel("联系方式:");
    JLabel are = new JLabel("店铺地址:");
    JLabel fac = new JLabel("出版社:");
    JLabel date = new JLabel("入库日期:");
    JLabel num = new JLabel("库存量:");

    JTextField idText = new JTextField();
    JTextField nameText = new JTextField();
    JTextField peoText = new JTextField();
    JTextField ipText = new JTextField();
    JTextField areText = new JTextField();
    JTextField facText = new JTextField();
    JTextField dateText = new JTextField();
    JTextField numText = new JTextField();
    JButton add = new JButton("确认添加");
    JButton cancel = new JButton("取消");
    AddHandler addHandler;
    static AddView addView;
    public AddView() {
        super("图书馆管理系统");
        addHandler = new AddHandler(this);
        Container contentPane = getContentPane();
        contentPane.add(jPanel);

        setUndecorated(true);

//        URL resource = LoginView.class.getClassLoader().getResource("ks.jpg");
//        assert resource != null;
//        Image image = new ImageIcon(resource).getImage();
//        setIconImage(image);

        Font jp1Font = new Font("楷体", Font.PLAIN, 30);
        add.setFont(jp1Font);
        cancel.setFont(jp1Font);
        id.setFont(jp1Font);
        idText.setPreferredSize(new Dimension(200, 40));
        item.setFont(jp1Font);
        nameText.setPreferredSize(new Dimension(200, 40));
        peo.setFont(jp1Font);
        peoText.setPreferredSize(new Dimension(200, 40));
        ip.setFont(jp1Font);
        ipText.setPreferredSize(new Dimension(200, 40));
        are.setFont(jp1Font);
        areText.setPreferredSize(new Dimension(200, 40));
        fac.setFont(jp1Font);
        facText.setPreferredSize(new Dimension(200, 40));
        date.setFont(jp1Font);
        dateText.setPreferredSize(new Dimension(200, 40));
        num.setFont(jp1Font);
        numText.setPreferredSize(new Dimension(200, 40));

        jPanel.setBackground(Color.LIGHT_GRAY);

        jPanel.add(id);
        jPanel.add(idText);
        jPanel.add(item);
        jPanel.add(nameText);
        jPanel.add(peo);
        jPanel.add(peoText);
        jPanel.add(ip);
        jPanel.add(ipText);
        jPanel.add(are);
        jPanel.add(areText);
        jPanel.add(fac);
        jPanel.add(facText);
        jPanel.add(date);
        jPanel.add(dateText);
        jPanel.add(num);
        jPanel.add(numText);
        jPanel.add(add);
        add.addActionListener(addHandler);
        jPanel.add(cancel);
        cancel.addActionListener(addHandler);

        add.setContentAreaFilled(false);
        cancel.setContentAreaFilled(false);

        addLayout();

        setSize(500, 750);
        setLocationRelativeTo(null);//居中显示
        setResizable(false);//大小不可以改变
        setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭结束程序
        setVisible(true);
    }

    public void addLayout() {
        Spring childWidth = Spring.sum(Spring.sum(Spring.width(id), Spring.width(idText)), Spring.constant(20));
        int offsetX = childWidth.getValue() / 2;

        springLayout.putConstraint(SpringLayout.EAST, id, -offsetX + 100, SpringLayout.HORIZONTAL_CENTER, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, id, 50, SpringLayout.NORTH, jPanel);

        springLayout.putConstraint(SpringLayout.NORTH, item, 30, SpringLayout.SOUTH, id);
        springLayout.putConstraint(SpringLayout.EAST, item, 0, SpringLayout.EAST, id);

        springLayout.putConstraint(SpringLayout.NORTH, peo, 30, SpringLayout.SOUTH, item);
        springLayout.putConstraint(SpringLayout.EAST, peo, 0, SpringLayout.EAST, item);

        springLayout.putConstraint(SpringLayout.NORTH, ip, 30, SpringLayout.SOUTH, peo);
        springLayout.putConstraint(SpringLayout.EAST, ip, 0, SpringLayout.EAST, peo);

        springLayout.putConstraint(SpringLayout.NORTH, are, 30, SpringLayout.SOUTH, ip);
        springLayout.putConstraint(SpringLayout.EAST, are, 0, SpringLayout.EAST, ip);

        springLayout.putConstraint(SpringLayout.NORTH, fac, 30, SpringLayout.SOUTH, are);
        springLayout.putConstraint(SpringLayout.EAST, fac, 0, SpringLayout.EAST, are);

        springLayout.putConstraint(SpringLayout.NORTH, date, 30, SpringLayout.SOUTH, fac);
        springLayout.putConstraint(SpringLayout.EAST, date, 0, SpringLayout.EAST, fac);

        springLayout.putConstraint(SpringLayout.NORTH, num, 30, SpringLayout.SOUTH, date);
        springLayout.putConstraint(SpringLayout.EAST, num, 0, SpringLayout.EAST, date);

        springLayout.putConstraint(SpringLayout.WEST, idText, 30, SpringLayout.EAST, id);
        springLayout.putConstraint(SpringLayout.NORTH, idText, 0, SpringLayout.NORTH, id);

        springLayout.putConstraint(SpringLayout.NORTH, nameText, 0, SpringLayout.NORTH, item);
        springLayout.putConstraint(SpringLayout.WEST, nameText, 0, SpringLayout.WEST, idText);

        springLayout.putConstraint(SpringLayout.NORTH, peoText, 0, SpringLayout.NORTH, peo);
        springLayout.putConstraint(SpringLayout.WEST, peoText, 0, SpringLayout.WEST, nameText);

        springLayout.putConstraint(SpringLayout.NORTH, ipText, 0, SpringLayout.NORTH, ip);
        springLayout.putConstraint(SpringLayout.WEST, ipText, 0, SpringLayout.WEST, peoText);

        springLayout.putConstraint(SpringLayout.NORTH, areText, 0, SpringLayout.NORTH, are);
        springLayout.putConstraint(SpringLayout.WEST, areText, 0, SpringLayout.WEST, ipText);

        springLayout.putConstraint(SpringLayout.NORTH, facText, 0, SpringLayout.NORTH, fac);
        springLayout.putConstraint(SpringLayout.WEST, facText, 0, SpringLayout.WEST, areText);

        springLayout.putConstraint(SpringLayout.NORTH, dateText, 0, SpringLayout.NORTH, date);
        springLayout.putConstraint(SpringLayout.WEST, dateText, 0, SpringLayout.WEST, facText);

        springLayout.putConstraint(SpringLayout.NORTH, numText, 0, SpringLayout.NORTH, num);
        springLayout.putConstraint(SpringLayout.WEST, numText, 0, SpringLayout.WEST, dateText);

        springLayout.putConstraint(SpringLayout.NORTH, add, 80, SpringLayout.SOUTH, num);
        springLayout.putConstraint(SpringLayout.WEST, add, 0, SpringLayout.WEST, num);

        springLayout.putConstraint(SpringLayout.NORTH, cancel, 0, SpringLayout.NORTH, add);
        springLayout.putConstraint(SpringLayout.EAST, cancel, 0, SpringLayout.EAST, numText);
    }

    public static void cre() {
        addView = new AddView();
    }
    public static void shutDown() {
        addView.dispose();
    }
    public String getIdText() {
        return idText.getText();
    }
    public String getNameText() {
        return nameText.getText();
    }
    public String getPeoText() {
        return peoText.getText();
    }
    public String getIpText() {
        return ipText.getText();
    }
    public String getAreText() {
        return areText.getText();
    }
    public String getFacText() {
        return facText.getText();
    }
    public String getDateText() {
        return dateText.getText();
    }
    public String getNumText() {
        return numText.getText();
    }
}
