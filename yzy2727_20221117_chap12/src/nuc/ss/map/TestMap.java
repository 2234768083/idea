/**
 *@Title TestMap
 *@Description  用Map集合存储电商购物平台中用户的信息
 *@Author gyw
 *@Date 2022年11月20日上午9:24:45
 */
package nuc.ss.map;

import java.util.*;

import nuc.ss.entity.User;

public class TestMap {
    public static void main(String[] args) {
    	User u1 = new  User("u00001","郭彦伟","123456","管理员",'男',"太原");
    	User u2 = new  User("u00002","张三","123456","管理员",'男',"太原");
    	User u3 = new  User("u00003","李四","123456","管理员",'男',"太原");
    	User u4 = new  User("u00004","王五","123456","管理员",'男',"太原");
    	User u5 = new  User("u00005","舞舞舞","123456","管理员",'男',"太原");
    	
    	//准备集合
    	Map<String,User> users = new TreeMap<>();
    	
    	//往集合中添加用户
    	users.put("u00001", u1);
    	users.put("u00002", u2);
    	users.put("u00003", u3);
    	users.put("u00004", u4);
    	
    	users.put("u00005", u5);
    	users.put("u00005", u5);
    	users.put("u00005", u5);
    	
    	//遍历所有的Key
    	System.out.println("遍历所有的Key");
    	Iterator<String> iterKey = users.keySet().iterator();
    	while(iterKey.hasNext()) {
    		System.out.println(iterKey.next());
    	}
    	
    	
    	
    	//遍历所有的value
    	System.out.println("遍历所有的value");
    	Iterator<User> iterValue = users.values().iterator();
    	while(iterKey.hasNext()) {
    		System.out.println(iterValue.next());
    	}
    	
    	//遍历所有的<key,value>
    	System.out.println("遍历所有的<key,value>");
    	
    	Iterator<Map.Entry<String,User>> iterEntry = users.entrySet().iterator();
    	while(iterEntry.hasNext()) {
    		Map.Entry<String,User> entry = iterEntry.next();
    		System.out.println("<" + entry.getKey() + ":" + entry.getValue() + ">");
    		
    	}
	}
}
