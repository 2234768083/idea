package nuc.ss.main;

import java.util.List;

import nuc.ss.dao.UserDao;
import nuc.ss.dao.UserDaoImpl;
import nuc.ss.entity.User;

/**
 * @author 2113042703 ����
 * @data
 * @description
 */
public class TestUserDaoImol {
    private UserDao userDao;

    public void init() {
        userDao = new UserDaoImpl();
    }

    public void testFindAll() {
        init();
        List<User> users = userDao.findAll();
        if (users.size() > 0) {
            for(User user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("��ʾ���û�����û�м�¼~");
        }
    }

    public void testLogin() {
        init();
        String username = "u0001";
        String password = "u0001";

        User user = userDao.login(username, password);
        if (user != null) {
            System.out.println("��ϲ��[" + username + "]��¼�ɹ�~");
        } else {
            System.out.println("�ź���[" + username + "]��¼ʧ��~");
        }

    }

    public static void main(String[] args) {
        new TestUserDaoImol().testLogin();
    }
}

