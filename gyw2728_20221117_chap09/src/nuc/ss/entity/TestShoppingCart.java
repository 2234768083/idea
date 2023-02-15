/**
 *@Title TestShoppingCart
 *@Description
 *@Author gyw
 *@Date 2022年11月20日上午11:29:35
 */
package nuc.ss.entity;

import nuc.ss.exception.CartException;

public class TestShoppingCart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//电商平台可买的书籍
		Book b1 = new Book("b00001", "数据结构算法", "严蔚敏", 45.6f, 20,new Category(1,"软件开发","算法"));
		Book b2 = new Book("b00002", "java", "严为民", 25.6f, 20,new Category(2,"软件开发","算法"));
		Book b3 = new Book("b00003", "西游记", "严为民", 35.6f, 20,new Category(3,"小说","名著"));
		Book b4 = new Book("b00004", "红楼梦", "严为民", 55.6f, 20,new Category(4,"小说","名著"));
		
		//为用户创建一辆购物车
		User u = new User("u00001","郭彦伟","123456","管理员",'男',"太原");
		ShoppingCart cart = new ShoppingCart();
		u.setCart(cart);
		
		//用户开始买书
		try {
			u.getCart().add(b1, 10);
			u.getCart().add(b2, 3);
			u.getCart().add(b3, 1);
			u.getCart().add(b4, 1);
			u.getCart().add(b1, 8);
			u.getCart().add(b1, 20);
		} catch (CartException e) {
			System.out.print(e);
		}finally {
			u.getCart().printDetails();
		}

	}

}
