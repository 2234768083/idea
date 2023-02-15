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

import nuc.ss.dao.DriverDao;
import nuc.ss.entity.Driver;

/**
 * @author 2113042703 王晰
 * @data
 * @description
 */
public class DriverFrame extends JFrame{
    JLabel j11=new JLabel("did           ");
    JLabel j12=new JLabel("user         ");
    JLabel j13=new JLabel("password              ");
    JLabel j14=new JLabel("name          ");
    JLabel j15=new JLabel("remuneration                ");//表头
    JLabel j16=new JLabel("bonus               ");
    JLabel j17=new JLabel("fine             ");
    JLabel j18=new JLabel("count ");

    JPanel jp2=new JPanel();  //表头
    JLabel j1=new JLabel("did");
    JLabel j2=new JLabel("user");
    JLabel j3=new JLabel("password");
    JLabel j4=new JLabel("name");
    JLabel j5=new JLabel("remuneration");
    JLabel j6=new JLabel("bonus");
    JLabel j7=new JLabel("fine");
    JLabel j8=new JLabel("count");
    JTextField f1=new JTextField(10);
    JTextField f2=new JTextField(10);
    JTextField f3=new JTextField(10);
    JTextField f8=new JTextField(10);
    JTextField f4=new JTextField(10);
    JTextField f5=new JTextField(10);
    JTextField f6=new JTextField(10);
    JTextField f7=new JTextField(10);
    JButton b1=new JButton("查询");
    JButton b2=new JButton("修改");
    JButton b3=new JButton("删除");
    JButton b4=new JButton("清空");
    JButton b5=new JButton("添加");

    final JTable t1=new JTable();
    public DriverFrame() {

        this.setTitle("司机档案");
        this.setLayout(null);
        this.setLocation(300,100 );
        this.setSize(1200,500 );
        this.setLayout(null);
        JPanel panel=new JPanel();
        JPanel panel2=new JPanel();
        panel.add(t1);
        panel.setBounds(70, 130,800, 1000);
        jp2.setBounds(70, 100, 800, 100); //表头
        this.add(panel);
        final Vector<String> title=new Vector<>();
        title.add("did");
        title.add("user");
        title.add("password");
        title.add("remuneration");
        title.add("name");
        title.add("bonus");
        title.add("fine");
        title.add("count");
        Vector value= DriverDao.query();
        final DefaultTableModel model=new DefaultTableModel(value,title);
        t1.setModel(model);
        if(t1.getRowCount()>0)
        {
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

                int row=t1.getSelectedRow();
                String did=t1.getValueAt(row, 0).toString();
                String user=t1.getValueAt(row, 1).toString();
                String password=t1.getValueAt(row, 2).toString();
                String name=t1.getValueAt(row, 3).toString();
                String remuneration=t1.getValueAt(row, 4).toString();
                String bonus=t1.getValueAt(row, 5).toString();
                String fine=t1.getValueAt(row, 6).toString();
                String count=t1.getValueAt(row,6).toString();
                f1.setText(did);
                f2.setText(user);
                f3.setText(password);
                f4.setText(name);
                f5.setText(remuneration);
                f6.setText(bonus);
                f7.setText(fine);
                f8.setText(count);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String did=String.valueOf(f1.getText()).trim();
                String user=f2.getText().trim();
                String password=f3.getText().trim();
                String name=f4.getText().trim();
                String remuneration=f5.getText().trim();
                String bonus=f6.getText().trim();
                String fine=f7.getText().trim();
                String count=f8.getText().trim();
                Driver good=new Driver();
                good.setDid(did);
                good.setName(name);
                good.setPassword(password);
                good.setUser(user);
                good.setBonus(bonus);
                good.setFine(fine);
                good.setCount(count);
                good.setRemuneration(remuneration);
                DriverDao.update(good);
                Vector value=DriverDao.query();
                final DefaultTableModel model=new DefaultTableModel(value,title);
                t1.setModel(model);
            }
        });


        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String did= String.valueOf(f1.getText()).trim();
                Driver good=new Driver();
                DriverDao.delete(did);
                Vector value=DriverDao.query();
                final DefaultTableModel model=new DefaultTableModel(value,title);
                t1.setModel(model);
            }
        });


        b5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String did= f1.getText().trim();
                String user=f2.getText().trim();
                String password=f3.getText().trim();
                String name=f4.getText().trim();
                String remuneration=f5.getText().trim();
                String bonus=f6.getText().trim();
                String fine=f7.getText().trim();
                String count=f8.getText().trim();
                Driver good=new Driver();
                good.setDid(did);
                good.setName(name);
                good.setPassword(password);
                good.setUser(user);
                good.setBonus(bonus);
                good.setFine(fine);
                good.setCount(count);
                good.setRemuneration(remuneration);
                DriverDao.insert(good);
                Vector value= null;
                value = DriverDao.query();
                final DefaultTableModel model=new DefaultTableModel(value,title);
                t1.setModel(model);

            }
        });
        jp2.add(j11);   //第一个表头
        jp2.add(j12);
        jp2.add(j13);
        jp2.add(j14);
        jp2.add(j15);
        jp2.add(j16);
        jp2.add(j17);
        jp2.add(j18);
        this.add(jp2);
        panel2.setBounds(0,20,1050,100);
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
        panel2.add(j6);
        panel2.add(f6);
        panel2.add(j7);
        panel2.add(f7);
        panel2.add(j8);
        panel2.add(f8);
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
        new DriverFrame();
    }

}

