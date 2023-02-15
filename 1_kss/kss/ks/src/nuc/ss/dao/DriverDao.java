package nuc.ss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;

import nuc.ss.entity.Driver;
import nuc.ss.jdbc.Basejdbc;

/**
 * @author 2113042703 ����
 * @data
 * @description
 */
public class DriverDao {

    /**
     * ��
     * @param d
     */
    public static void insert(Driver d) {
        try {
            Connection conn = Basejdbc.getConn();
            PreparedStatement ps = conn.prepareStatement("insert into driver(did,user,password,remuneration,bonus,fine,count)values(?,?,?,?,?,?,?)");
            ps.setString(1,d.getDid());
            ps.setString(2,d.getUser());
            ps.setString(3,d.getPassword());
            ps.setString(4,d.getRemuneration());
            ps.setString(5,d.getBonus());
            ps.setString(6,d.getFine());
            ps.setString(7,d.getCount());
            int f = ps.executeUpdate();
            if(f>0) {
                JOptionPane.showMessageDialog(null,"�ɹ�����");
            } else {
                JOptionPane.showMessageDialog(null,"no");
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ע�ⲻ�ظ�");
        }
    }

    /**
     * ɾ
     * @param did
     */
    public static void delete(String did)
    {
        try {
            Connection conn=Basejdbc.getConn();
            PreparedStatement ps=conn.prepareStatement("delete from driver where did=?");
            ps.setString(1,did);
            int f=ps.executeUpdate();
            if(f>0)
            {
                JOptionPane.showMessageDialog(null, "�ɹ�ɾ������");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "û��ɾ������");
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "����ʧ��");
        }
    }

    public static void update(Driver g)
    {
        try {
            Connection con=Basejdbc.getConn();
            PreparedStatement ps=con.prepareStatement("update goods set did=?,user=?,password=?,name=?,remuneration=?,bonus=?,fine=?,count=? where did=?");
            ps.setString(1, g.getDid());
            ps.setString(2, g.getUser());
            ps.setString(3, g.getPassword());
            ps.setString(4, g.getName());
            ps.setString(5, g.getRemuneration());
            ps.setString(6, g.getBonus());
            ps.setString(7, g.getFine());
            ps.setString(8, g.getCount());
            ps.setString(9, g.getDid());
            int f=ps.executeUpdate();
            System.out.println(f);
            if(f>0)
            {
                JOptionPane.showMessageDialog(null, "�ɹ���������");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "û�������ĸ�������");
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "û�гɹ���������");
        }
    }
    public static void update(String name,String did)
    {
        try {
            Connection con=Basejdbc.getConn();
            PreparedStatement ps=con.prepareStatement("update driver set name=name-? where did=?");
            ps.setString(1, name);
            ps.setString(2, did);
            int f=ps.executeUpdate();
            System.out.println(f);
            if(f>0)
            {
                JOptionPane.showMessageDialog(null, "�ɹ���������");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "û�������ĸ�������");
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "û�гɹ���������");
        }
    }


    /**
     * ��
     * @return
     */
    public static Vector query() {
        try {
            Vector vector=new Vector();
            Connection conn=Basejdbc.getConn();
            PreparedStatement ps=conn.prepareStatement("select * from driver ");
            ResultSet rs=ps.executeQuery();
            while(rs.next()&&rs.getRow()>0)
            {
                Vector row=new Vector();
                for(int col=1;col<=rs.getMetaData().getColumnCount();col++)
                {
                    if(col==3||col==4)
                    {
                        row.add(String.valueOf(rs.getString(col)));
                    }
                    else if(col==7||col==1)
                    {
                        row.add(String.valueOf(rs.getString(col)));
                    }
                    else
                    {
                        row.add(String.valueOf(rs.getString(col)));
                    }
                }
                vector.add(row);
            }
            return vector;
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "��ѯʧ��");
            e.printStackTrace();
            return null;
        }

    }

    }




