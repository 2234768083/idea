package nuc.ss.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import nuc.ss.dao.CostDao;
import nuc.ss.entity.Cost;

/**
 * @author
 * @data
 * @description
 */
public class CostFrame extends JFrame {
    JLabel j11 = new JLabel("cid           ");
    JLabel j12 = new JLabel("introduce         ");
    JLabel j13 = new JLabel("time             ");
    JLabel j14 = new JLabel("name          ");
    JLabel j15 = new JLabel("allCard               ");//表头

    JPanel jp2 = new JPanel();  //表头
    JLabel j1 = new JLabel("cid");
    JLabel j2 = new JLabel("introduce");
    JLabel j3 = new JLabel("time");
    JLabel j4 = new JLabel("name");
    JLabel j5 = new JLabel("allCard");
    JTextField f1 = new JTextField(10);
    JTextField f2 = new JTextField(10);
    JTextField f3 = new JTextField(10);
    JTextField f5 = new JTextField(10);
    JTextField f4 = new JTextField(10);
    JButton b1 = new JButton("查询");
    JButton b2 = new JButton("修改");
    JButton b3 = new JButton("删除");
    JButton b4 = new JButton("清空");
    JButton b5 = new JButton("添加");

    final JTable t1 = new JTable();

    public CostFrame() {

        this.setTitle("费用");
        this.setLayout(null);
        this.setLocation(300, 100);
        this.setSize(1200, 500);
        this.setLayout(null);
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        panel.add(t1);
        panel.setBounds(70, 130, 800, 1000);
        jp2.setBounds(70, 100, 800, 100); //表头
        this.add(panel);
        final Vector<String> title = new Vector<>();
        title.add("cid");
        title.add("introduce");
        title.add("time");
        title.add("name");
        title.add("allCard");
        Vector value = CostDao.query();
        final DefaultTableModel model = new DefaultTableModel(value, title);
        t1.setModel(model);
        if (t1.getRowCount() > 0) {
            t1.setRowSelectionInterval(0, 0);
        }
        t1.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseClicked(MouseEvent e) {

                int row = t1.getSelectedRow();
                String cid = t1.getValueAt(row, 0).toString();
                String introduce = t1.getValueAt(row, 1).toString();
                String time = t1.getValueAt(row, 2).toString();
                String name = t1.getValueAt(row, 3).toString();
                String allCard = t1.getValueAt(row, 4).toString();
                f1.setText(cid);
                f2.setText(introduce);
                f3.setText(time);
                f4.setText(name);
                f5.setText(allCard);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cid = String.valueOf(f1.getText()).trim();
                String introduce = f2.getText().trim();
                String time = f3.getText().trim();
                String name = f4.getText().trim();
                String allCard = f5.getText().trim();
                Cost good = new Cost() ;
                good.setCid(cid);
                good.setName(introduce);
                good.setTime(time);
                good.setName(name);
                good.setAllCard(allCard);
                CostDao.update(good);
                Vector value = CostDao.query();
                final DefaultTableModel model = new DefaultTableModel(value, title);
                t1.setModel(model);
            }
        });


        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String did = String.valueOf(f1.getText()).trim();
                Cost good = new Cost();
                CostDao.delete(did);
                Vector value = CostDao.query();
                final DefaultTableModel model = new DefaultTableModel(value, title);
                t1.setModel(model);
            }
        });


        b5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String cid = f1.getText().trim();
                String introduce = f2.getText().trim();
                String time = f3.getText().trim();
                String name = f4.getText().trim();
                String allCard = f5.getText().trim();
                Cost good = new Cost();
                good.setCid(cid);
                good.setIntroduce(introduce);
                good.setTime(time);
                good.setName(name);
                good.setAllCard(allCard);
                CostDao.insert(good);
                Vector value = null;
                value = CostDao.query();
                final DefaultTableModel model = new DefaultTableModel(value, title);
                t1.setModel(model);

            }
        });
        jp2.add(j11);   //第一个表头
        jp2.add(j12);
        jp2.add(j13);
        jp2.add(j14);
        jp2.add(j15);
        this.add(jp2);
        panel2.setBounds(0, 20, 1050, 100);
        panel2.add(j1);
        panel2.add(f1);
        panel2.add(j2);
        panel2.add(f2);
        panel2.add(j3);
        panel2.add(f3);
        panel2.add(j4);
        panel2.add(f4);
        panel2.add(j5);
        panel2.add(f5);
        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);
        panel2.add(b4);
        panel2.add(b5);
        this.setResizable(false); //设置不可以变大
        this.add(panel2);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new CostFrame();
    }
}

