/**
 *@Title TestList
 *@Description 用ArrayList存储用户信息
 *@Author gyw
 *@Date 2022年11月17日上午10:53:58
 */
package nuc.ss.list;

import java.util.*;

import nuc.ss.entity.User;

public class TestList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<User> users = new ArrayList<User>();
		users.add(new User("u00001","郭彦伟","123456","管理员",'男',"太原"));
		users.add(new User("u00002","张三","123456","管理员",'男',"太原"));
		users.add(new User("u00003","李四","123456","管理员",'男',"太原"));
		users.add(new User("u00004","王五","123456","管理员",'男',"太原"));
		
		User u5 = new User("u00005","舞舞舞","123456","管理员",'男',"太原");
		users.add(u5);
		users.add(u5);
		users.add(u5);
		
		//集合的第一种遍历方式：普通的for
		System.out.println("List集合的第一种遍历方式：普通的for:");
		for(int i=0;i<users.size();i++) {
			System.out.println(users.get(i));
			
		}
		
		//集合的第二种遍历方式：特殊的for
		System.out.println("List集合的第二种遍历方式：特殊的for:");
		for(User u:users) {
			System.out.println(u);
		}
		
		//集合的第三种遍历方式：迭代器
		System.out.println("List集合的第三种遍历方式：迭代器:");
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}

}
