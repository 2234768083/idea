/**
 *@Title TextSet
 *@Description
 *@Author gyw
 *@Date 2022年11月17日上午11:19:47
 */
package nuc.ss.set;

import java.util.*;

import nuc.ss.entity.User;

public class TestSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Set<User> users = new HashSet<User>();
		users.add(new User("u00001","郭彦伟","123456","管理员",'男',"太原"));
		users.add(new User("u00002","张三","123456","管理员",'男',"太原"));
		users.add(new User("u00003","李四","123456","管理员",'男',"太原"));
		users.add(new User("u00004","王五","123456","管理员",'男',"太原"));
		
		User u5 = new User("u00005","舞舞舞","123456","管理员",'男',"太原");
		users.add(u5);
		users.add(u5);
		users.add(u5);
		
		//集合的第一种遍历方式：普通的for:必须要转换成数组
		System.out.println("Set集合的第一种遍历方式：普通的for:");
		Object[] userArray = users.toArray();
		for(int i=0;i<userArray.length;i++) {
			System.out.println(userArray[i]);
			
		}
		
		//Set集合的第二种遍历方式：特殊的for
		System.out.println("Set集合的第二种遍历方式：特殊的for:");
		for(User u:users) {
			System.out.println(u);
		}
		
		//Set集合的第三种遍历方式：迭代器
		System.out.println("Set集合的第三种遍历方式：迭代器:");
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}

}

