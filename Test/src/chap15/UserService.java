package chap15;

/**
   模拟用户业务功能
 */
public interface UserService {
    String login(String loginName , String passWord) ;
    void selectUsers();
    boolean deleteUsers();
    void updateUsers();
}
