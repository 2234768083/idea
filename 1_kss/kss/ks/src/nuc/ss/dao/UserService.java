package nuc.ss.dao;

import java.util.List;

import nuc.ss.entity.User;

/**
 * @author 2113042703 ����
 * @data
 * @description
 */
public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDaoImpl();
    }
    public int addUser(User user) {
        return userDao.insert(user);
    }

    public int deleteUser(int id) {
        return userDao.delete(String.valueOf(id));
    }

    public int updateUser(User user) {
        return userDao.update(user);
    }

    public User findUserById(int id) {
        return userDao.findById(String.valueOf(id));
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public User login(String username, String password) {
        return userDao.login(username, password);
    }

}

