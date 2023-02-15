package yzy2727_20221117.nuc.ss.list;

import yzy2727_20221117.eneity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class TestList {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User("u00001","李华玲","12334","管理员", "女","太原"));
        users.add(new User("u00002","张三","12334","管理员", "女","太原"));
        users.add(new User("u00003","李四","12334","管理员", "女","太原"));
        users.add(new User("u00004","王五","12334","管理员", "女","太原"));

        User u5 = new User("u00005","舞舞舞","12334","管理员", "女","太原");
        users.add(u5);
        users.add(u5);
        users.add(u5);

        //集合的第一种遍历方式
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }

        System.out.println("集合的第二种遍历方式：特殊的for");
        for (User u: users) {
            System.out.println(u);
        }

        System.out.println("集合的第三种形式：迭代器");
        Iterator<User> iter = users.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
