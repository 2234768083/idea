package yzy2727_20221117.eneity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        // 准备用户
        User u1 = new User("u00001","李华玲","12334","管理员", "女","太原");
        User u2 = new User("u00002","张三","12334","管理员", "女","太原");
        User u3 = new User("u00003","李四","12334","管理员", "女","太原");
        User u4 = new User("u00004","王五","12334","管理员", "女","太原");
        User u5 = new User("u00005","舞舞舞","12334","管理员", "女","太原");

        // 准备集合
        Map<String, User> users = new TreeMap<>();

        // 往集合中添加用户
        users.put("u00001", u1);
        users.put("u00002", u2);
        users.put("u00003", u3);
        users.put("u00004", u4);

        users.put("u00005", u5);
        users.put("u00005", u5);
        users.put("u00005", u5);

        // 遍历所有的key
        System.out.println("遍历所有的key：");
        Iterator<String> interKey = users.keySet().iterator();
        while (interKey.hasNext()) {
            System.out.println(interKey.next());
        }

        // 遍历所有的value
        System.out.println("遍历所有的value：");
        Iterator<User> interValue = users.values().iterator();
        while (interValue.hasNext()) {
            System.out.println(interValue.next());
        }

        // 遍历所有的<key , value>
        System.out.println("遍历所有的<key , value>：");

        Iterator<Map.Entry<String, User>> iterEntry = users.entrySet().iterator();
        while (iterEntry.hasNext()) {
            Map.Entry<String, User> entry = iterEntry.next();
            System.out.println("<" + entry.getKey() + "," + entry.getValue() + ">");

        }
    }
}
