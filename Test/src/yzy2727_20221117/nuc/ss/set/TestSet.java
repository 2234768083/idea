package yzy2727_20221117.nuc.ss.set;

import yzy2727_20221117.eneity.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Set<User> users = new HashSet<User>();
        users.add(new User("u00001","杨嘉诚","123456","管理员", "男","太原"));
        users.add(new User("u00002","张三","123456","管理员", "男","太原"));
        users.add(new User("u00003","李四","123456","管理员", "男","太原"));
        users.add(new User("u00004","王五","123456","管理员", "男","太原"));

        User u5 = new User("u00005","舞舞舞","123456","管理员", "男","太原");
        users.add(u5);
        users.add(u5);
        users.add(u5);

        //Set集合的第一种遍历方式：普通的for
        System.out.println("Set集合的第一种遍历方式：普通的for:");
        Object[] userArray = users.toArray();
        for(int i=0;i<userArray.length;i++) {
            System.out.println(userArray[i]);

        }

        //集合的第二种遍历方式：特殊的for
        System.out.println("集合的第二种遍历方式：特殊的for:");
        for(User u:users) {
            System.out.println(u);
        }

        //集合的第三种遍历方式：迭代器
        System.out.println("集合的第三种遍历方式：迭代器:");

        Iterator iter = users.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

    }

}