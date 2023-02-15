package nuc.ss.shopping1.entity;

/**
 * 用户类：mvc：Model模型层User.java; View视图层RegisterFrame.java;Control控制层：注册按钮事件处理的匿名内部类
 */
public class User {
    private String id;
    private String name;
    private String password;
    private String type;
    private char sex;
    private String city;

    public User(String id, String name, String password, String type, char sex, String city) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.type = type;
        this.sex = sex;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", sex=" + sex +
                ", city='" + city + '\'' +
                '}';
    }
}
