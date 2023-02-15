package nuc.ss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * @author 2113042703 王晰
 * @data
 * @description
 */
public class Basejdbc {
    private static Basejdbc dao=new Basejdbc();
    public  Basejdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "数据库加载失败"+e.getMessage());
        }
    }
    public static Connection getConn() {
        Connection conn=null;
        try {

            String url="jdbc:mysql://localhost:3306/driverfiles?&characterEncoding=utf-8";   //127.0.0.1:3306
            conn=DriverManager.getConnection(url,"root","160829");
            System.out.println("连接成功");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "数据库连接失败"+e.getMessage());
            return null;
        }
        return conn;
    }

    public static void closeConn(Connection conn) {
        if(conn != null) {
            try{
                // 判断连接是否关闭
                if (!conn.isClosed()) {
                    // 关闭数据库连接，释放资源
                    conn.close();
                    // 提示用户
                    System.out.println("提示：数据库连接关闭~");
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }
    }

    public static void main(String[] args) {
    Connection conn = getConn();
    closeConn(conn);
    }

}

