package nuc.ss.shopping3.view;

import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import nuc.ss.shopping3.dao.*;
import nuc.ss.shopping3.entity.*;

public class QueryFrame extends JFrame {
    private JLabel l_welcome, l_city;
    private JLabel l_bName, l_category;
    private JTextField t_bName;
    private JComboBox<String> c_category;
    private JButton b_query, b_buy, b_add;
    private JTable jTable;
    private JLabel l_cart;
    private JSeparator sep;
    JScrollPane jScrollPane;

    public QueryFrame(User user) {
        this.setTitle("商品查询页面");
        this.setSize(800, 500);
        this.setResizable(true);
        this.setLocation(1100, 400);
        init(user);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(User user) {
        // this.setLayout(new GridLayout(3, 1, 5, 5));
        this.setLayout(null);
        JPanel p1 = new JPanel(new GridLayout(1, 2));

        BookDao bd = new BookDaoImpl();
        List<Book> books = bd.queryBooks();
        String[][] data = new String[books.size()][5];

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) != null) {
                data[i][0] = books.get(i).getBid();
                data[i][1] = books.get(i).getName();
                data[i][2] = books.get(i).getAuthor();
                data[i][3] = books.get(i).getNumber() + "";
                data[i][4] = books.get(i).getCategory().toString();
            }
        }

        String[] columnNames = { "书籍编号", "书籍名称", "书籍作者", "库存", "书籍分类" };
        l_welcome = new JLabel("您好," + user.getName() + "(" + user.getUserType() + ")", JLabel.LEFT);
        l_city = new JLabel("来自于：" + user.getCity(), JLabel.RIGHT);
        l_bName = new JLabel("书籍名：");
        t_bName = new JTextField();
        l_category = new JLabel("分类：");
        c_category = new JComboBox<>();
        c_category.addItem("-请选择-");
        c_category.addItem("工具类 > 软件编程");
        c_category.addItem("小说类 > 历史");
        b_query = new JButton("查询");
        DefaultTableModel tModel = new DefaultTableModel(data, columnNames);
        jTable = new JTable(tModel);

        l_cart = new JLabel("购物车商品数：0件");
        b_buy = new JButton("购买");
        b_add = new JButton("添加书籍");

        sep = new JSeparator();

        p1.add(l_welcome);
        p1.add(l_city);
        this.add(p1);
        p1.setBounds(10, 10, 650, 30);
        this.add(sep);
        sep.setBounds(10, 40, 750, 10);
        this.add(l_bName);
        l_bName.setBounds(10, 60, 50, 30);
        this.add(t_bName);
        t_bName.setBounds(60, 60, 200, 30);
        this.add(l_category);
        l_category.setBounds(300, 60, 50, 30);
        this.add(c_category);
        c_category.setBounds(350, 60, 200, 30);
        this.add(b_query);
        b_query.setBounds(600, 60, 100, 30);
        jScrollPane = new JScrollPane(jTable);
        this.add(jScrollPane);
        jScrollPane.setBounds(10, 110, 750, 250);

        // 如果是普通用户，添加“购买”按钮，“购物车功能”
        if (user.getUserType().equals("普通用户")) {
            this.add(l_cart);
            l_cart.setBounds(10, 400, 750, 30);
            this.add(b_buy);
            b_buy.setBounds(600, 400, 100, 30);
        }

        // 如果是管理员，则添加“添加书籍”按钮
        if (user.getUserType().equals("管理员")) {
            this.add(b_add);
            b_add.setBounds(600, 400, 100, 30);

        }

        b_query.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<Book> result;
                if (c_category.getSelectedIndex() == 0) {
                    result = bd.queryBooks();
                } else {
                    String str = (String) c_category.getSelectedItem();
                    String[] strs = str.split(" > ");
                    Category c = new Category(strs[0], strs[1]);
                    result = bd.queryByCategory(c);
                }
                String[][] data = new String[result.size()][5];
                for (int i = 0; i < result.size(); i++) {
                    if (result.get(i) != null) {
                        data[i][0] = result.get(i).getBid();
                        data[i][1] = result.get(i).getName();
                        data[i][2] = result.get(i).getAuthor();
                        data[i][3] = result.get(i).getNumber() + "";
                        data[i][4] = result.get(i).getCategory().toString();
                    }
                }
                tModel.setDataVector(data, columnNames);
                // jTable = new JTable(data, columnNames);
                // jScrollPane = new JScrollPane(jTable);
                // add(jScrollPane);
                // jScrollPane.setBounds(10, 110, 750, 250);
            }

        });

        b_add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookFrame();
                List<Book> books = bd.queryBooks();
                String[][] data = new String[books.size()][5];

                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i) != null) {
                        data[i][0] = books.get(i).getBid();
                        data[i][1] = books.get(i).getName();
                        data[i][2] = books.get(i).getAuthor();
                        data[i][3] = books.get(i).getNumber() + "";
                        data[i][4] = books.get(i).getCategory().toString();
                    }
                }
                tModel.setDataVector(data, columnNames);
            }

        });
    }

    public static void main(String[] args) {
        new QueryFrame(new User("10001", "张三", "123456", "男", "北京", "管理员"));
    }
}
