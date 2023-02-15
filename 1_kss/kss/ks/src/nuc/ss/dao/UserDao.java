package nuc.ss.dao;

import java.util.List;

import nuc.ss.entity.User;

/**
 * @author 2113042703 ����
 * @data
 * @description
 */
public interface UserDao {
    int insert(User user);
    int delete(String id);
    int update(User user);
    User findById(String id);
    List<User> findAll();
    User login(String username,String password);
}
