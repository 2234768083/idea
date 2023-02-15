/**
 * @Title:OilDao.java
 * @Package:nuc.ss.ts.dao
 * @Description: TODO
 * @author:32987 zzh
 * @date: 2022��12��28��
 * @version V1.0
 */
package nuc.ss.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;

import nuc.ss.entity.Oilcard;
import nuc.ss.jdbc.Basejdbc;


public class OilcardDao {
    /**
     * ��
     * @param o
     */
	public static void insert(Oilcard o) {
		try {
			Connection conn = Basejdbc.getConn();
            PreparedStatement ps = conn.prepareStatement("insert into car(oid,name,price, remainprice)values(?,?,?,?)");
            ps.setString(1,o.getOid());
            ps.setString(2,o.getName());
            ps.setString(3,o.getPrice());
            ps.setString(4,o.getRemainprice());
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
	 * @param oid
	 */
	public static void delete(String oid)
    {
        try {
            Connection conn=Basejdbc.getConn();
            PreparedStatement ps=conn.prepareStatement("delete from car where oid=?");
            ps.setString(1,oid);
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

    public static void update(Oilcard g)
    {
        try {
            Connection con=Basejdbc.getConn();
            PreparedStatement ps=con.prepareStatement("update goods set oid=?,user=?,password=?,type=?,volume=?,state=?,where oid=?");
            ps.setString(1, g.getOid());
            ps.setString(2, g.getName());
            ps.setString(3, g.getPrice());
            ps.setString(4, g.getRemainprice());

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
    public static void update(String name,String oid)
    {
        try {
            Connection con=Basejdbc.getConn();
            PreparedStatement ps=con.prepareStatement("where oid=?");
            ps.setString(1, oid);
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
            PreparedStatement ps=conn.prepareStatement("select * from oilcard ");
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