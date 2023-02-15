/**
*@Title AddCarFrame
*@Description
*@Author 牛佳欣
*@Date2022年12月22日下午5:00:30
*
 */
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

import nuc.ss.dao.CarDao;
import nuc.ss.entity.Car;

public class CarFrame extends JFrame{
	JLabel j11=new JLabel("did           ");
    JLabel j12=new JLabel("user         ");
    JLabel j13=new JLabel("password              ");
    JLabel j14=new JLabel("type          ");
    JLabel j15=new JLabel("volume               ");//表头
    JLabel j16=new JLabel("state               ");

    JPanel jp2=new JPanel();  //表头
    JLabel j1=new JLabel("did");
    JLabel j2=new JLabel("user");
    JLabel j3=new JLabel("password");
    JLabel j4=new JLabel("type");
    JLabel j5=new JLabel("volume");
    JLabel j6=new JLabel("state");

    JTextField f1=new JTextField(10);
    JTextField f2=new JTextField(10);
    JTextField f3=new JTextField(10);
    JTextField f4=new JTextField(10);
    JTextField f5=new JTextField(10);
    JTextField f6=new JTextField(10);

    JButton b1=new JButton("查询");
    JButton b2=new JButton("修改");
    JButton b3=new JButton("删除");
    JButton b4=new JButton("清空");
    JButton b5=new JButton("添加");

    final JTable t1=new JTable();
    public CarFrame() {

        this.setTitle("车辆管理");
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
        title.add("type");
        title.add("volume");
        title.add("state");

        Vector value= CarDao.query();
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
                String type=t1.getValueAt(row, 3).toString();
                String volume=t1.getValueAt(row, 4).toString();
                String state=t1.getValueAt(row, 5).toString();
                f1.setText(did);
                f2.setText(user);
                f3.setText(password);
                f4.setText(type);
                f5.setText(volume);
                f6.setText(state);

            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cid=String.valueOf(f1.getText()).trim();
                String type=f4.getText().trim();
                String volume=f5.getText().trim();
                String state=f6.getText().trim();
                Car good=new Car();
                good.setCid(cid);
                good.setType(type);
                good.setVolume(volume);
                good.setState(state);
                CarDao.update(good);
                Vector value=CarDao.query();
                final DefaultTableModel model=new DefaultTableModel(value,title);
                t1.setModel(model);
            }
        });


        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String cid= String.valueOf(f1.getText()).trim();
                Car good=new Car();
                CarDao.delete(cid);
                Vector value=CarDao.query();
                final DefaultTableModel model=new DefaultTableModel(value,title);
                t1.setModel(model);
            }
        });


        b5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String cid= f1.getText().trim();
                String type=f4.getText().trim();
                String volume=f5.getText().trim();
                String state=f6.getText().trim();

                Car good=new Car();
                good.setCid(cid);
                good.setType(type);
                good.setVolume(volume);
                good.setState(state);
                CarDao.insert(good);
                Vector value= null;
                value = CarDao.query();
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
        new CarFrame();
    }

}

