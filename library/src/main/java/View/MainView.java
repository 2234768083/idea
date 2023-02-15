package View;

import Handler.MainHandler;
import db.DbInit;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;

public class MainView extends JFrame{
    JPanel jpr = new JPanel(new BorderLayout());
    JPanel jpu = new JPanel(new BorderLayout());
    SpringLayout springLayout = new SpringLayout();
    JPanel jpuCenter = new JPanel(springLayout);
    int h = (new Date()).getHours();
    JLabel time = new JLabel();
    JButton exit = new JButton("退出");
    MainHandler mainHandler;
    JPanel northJPanel = new JPanel();
    JButton add = new JButton("添加");
    JButton update = new JButton("修改");
    JButton del = new JButton("删除");
    private static MainView mainView;

    public MainView() throws IOException {
        super("图书馆管理系统");
        mainHandler = new MainHandler(this);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        layoutMain(contentPane);

        if (h >= 5 && h < 11) time.setText("早上好！");
        else if (h >= 11 && h < 14) time.setText("中午好！");
        else if (h >= 14 && h < 19) time.setText("下午好！");
        else time.setText("晚上好！");

        //自定义程序图标
//        URL resource = MainView.class.getClassLoader().getResource("ks.jpg");
//        assert resource != null;
//        Image image = new ImageIcon(resource).getImage();
//        setIconImage(image);

        jpu.setPreferredSize(new Dimension(0, 60));
        northJPanel.setPreferredSize(new Dimension(0, 50));
        jpr.setBackground(Color.WHITE);
        jpu.setBackground(Color.WHITE);
        northJPanel.setBackground(Color.WHITE);
        jpuCenter.setBackground(Color.WHITE);

        contentPane.add(jpu, BorderLayout.NORTH);
        contentPane.add(jpr, BorderLayout.CENTER);
        jpr.add(northJPanel, BorderLayout.NORTH);

        time.setFont(new Font("楷体", Font.PLAIN, 50));
        time.setSize(new Dimension(150, 0));
        exit.setFont(new Font("楷体", Font.PLAIN, 50));
        exit.setSize(new Dimension(150, 0));
        exit.setBackground(Color.WHITE);
        Font northFont = new Font("楷体", Font.PLAIN, 30);
        add.setFont(northFont);
        update.setFont(northFont);
        del.setFont(northFont);
        add.setContentAreaFilled(false);
        update.setContentAreaFilled(false);
        del.setContentAreaFilled(false);

        jpu.add(time, BorderLayout.WEST);
        jpu.add(exit, BorderLayout.EAST);
        exit.addActionListener(mainHandler);
        add.addActionListener(mainHandler);
        update.addActionListener(mainHandler);
        del.addActionListener(mainHandler);
        jpu.add(jpuCenter, BorderLayout.CENTER);
        northJPanel.add(add);
        northJPanel.add(update);
        northJPanel.add(del);

        setSize(1000, 666);
        setUndecorated (true);//设置当前JFrame窗口无边框
        setLocationRelativeTo(null);//居中显示
        setResizable(false);//设置大小不可改变
        setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭结束程序
        setVisible(true);
    }

    public static void shutDown() {
        mainView.dispose();
    }

    public static void cre() throws IOException {
        mainView = new MainView();
    }

    private void layoutMain(Container contentPane) throws IOException {

        Vector<Vector<Object>> data = new Vector<>();

        data = DbInit.init();

        TableModel tableModel = TableModel.init(data);

        JTable jTable = new JTable(tableModel);

        JTableHeader jTableHeader = jTable.getTableHeader();
        jTableHeader.setFont(new Font("楷书", Font.BOLD, 23));
        jTableHeader.setForeground(Color.BLUE);

        jTable.setFont(new Font(null, Font.PLAIN, 20));
        jTable.setForeground(Color.black);
        jTable.setGridColor(Color.BLACK);
        jTable.setRowHeight(30);
        //设置多行选择
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //设置表格列的渲染方式
        Vector<Object> col = TableModel.getCol();
        TableRender tableRender = new TableRender();
        for ( int i = 0; i < col.size(); i ++ ) {
            TableColumn column = jTable.getColumn(col.get(i));
            column.setCellRenderer(tableRender);
            if (i == 0) {
                column.setResizable(false);
                column.setMaxWidth(50);
                column.setPreferredWidth(50);
            }
        }

        JScrollPane jScrollPane = new JScrollPane(jTable);
        jpr.add(jScrollPane, BorderLayout.CENTER);
    }
}

class TableRender extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (row % 2 == 0) {
            setBackground(Color.WHITE);
        } else {
            setBackground(Color.WHITE);
        }
        setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}

class TableModel extends DefaultTableModel {
    static Vector<Object> col = new Vector<>();
    static {
        col.addElement("编号");
        col.addElement("书籍名");
        col.addElement("销售店铺");
        col.addElement("联系方式");
        col.addElement("店铺地址");
        col.addElement("出版社");
        col.addElement("入库日期");
        col.addElement("库存量");
    }

    private TableModel() {
        super(null, col);
    }

    private static final TableModel tableModel = new TableModel();

    public static TableModel init(Vector<Vector<Object>> data) {
        tableModel.setDataVector(data, col);
        return tableModel;
    }

    public static Vector<Object> getCol() {
        return col;
    }

    @Override
    public boolean isCellEditable(int row, int colum) {
        return false;
    }
}