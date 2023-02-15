package nuc.ss.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;

import nuc.ss.entity.Cost;
import nuc.ss.jdbc.Basejdbc;

public class CostDao {


    /**
     * ��
     * @param d
     */
    public static void insert(Cost d) {
        try {
            Connection conn = Basejdbc.getConn();
            PreparedStatement ps = conn.prepareStatement("insert into driver(cid,introduce,time,name,allCard)values(?,?,?,?,?,?)");
            ps.setString(1,d.getCid());
            ps.setString(2,d.getIntroduce());
            ps.setString(3,d.getTime());
            ps.setString(4,d.getName());
            ps.setString(5,d.getAllCard());
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
     * @param cid
     */
    public static void delete(String cid)
    {
        try {
            Connection conn=Basejdbc.getConn();
            PreparedStatement ps=conn.prepareStatement("delete from driver where cid=?");
            ps.setString(1,cid);
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

    public static void update(Cost g)
    {
        try {
            Connection con=Basejdbc.getConn();
            PreparedStatement ps=con.prepareStatement("update goods set cid=?,introduce=?,time=?,name=?,allCard=?");
            ps.setString(1, g.getCid());
            ps.setString(2, g.getIntroduce());
            ps.setString(3, g.getTime());
            ps.setString(4, g.getName());
            ps.setString(5, g.getAllCard());
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
    public static void update(String name,String cid)
    {
        try {
            Connection con=Basejdbc.getConn();
            PreparedStatement ps=con.prepareStatement("update driver set name=name-? where cid=?");
            ps.setString(1, name);
            ps.setString(2,  cid);
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
            PreparedStatement ps=conn.prepareStatement("select * from cost ");
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
