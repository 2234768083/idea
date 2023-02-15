package nuc.ss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nuc.ss.entity.User;
import nuc.ss.jdbc.Basejdbc;

/**
 * @author 2113042703 ����
 * @data
 * @description
 */
public class UserDaoImpl implements UserDao{
    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        // �����û��б�
        List<User> users = new ArrayList<>();

        // 1. ��ȡ���ݿ�����
        Connection conn = Basejdbc.getConn();
        // 2. ����SQL�ַ���
        String strSQL = "select * from user";
        try {
            // 3. ����������
            Statement stmt = conn.createStatement();
            // 4. ִ��SQL��ѯ�����ؽ����
            ResultSet rs = stmt.executeQuery(strSQL);
            // 5. ����������������û��б�
            while (rs.next()) {
                // �����û�����
                User user = new User();
                // �õ�ǰ��¼�ֶ�ֵ�����û���������
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                // ���û�������ӵ��û��б�
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
           Basejdbc.closeConn(conn);
        }
        // �����û��б�
        return users;
    }

    @Override
    public User login(String username, String password) {
        // �����û�����
        User user = null;

        // 1. ��ȡ���ݿ�����
        Connection conn = Basejdbc.getConn();
        // 2. ����SQL�ַ���
        String strSQL = "select * from user where username = ? and password = ?";
        try {
            // 3. ����Ԥ��������׼���ṩ������
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            // 4. �ò���ֵ����ռλ����ֵ
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            // 5. ִ��SQL��ѯ�����ؽ����
            ResultSet rs = pstmt.executeQuery();
            // 6. ������������ü�¼ֵ����û�����
            while (rs.next()) {
                // �����û�����
                user = new User();
                // �õ�ǰ��¼�ֶ�ֵ�����û���������
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            Basejdbc.closeConn(conn);
        }

        // �����û�����
        return user;
    }
}

