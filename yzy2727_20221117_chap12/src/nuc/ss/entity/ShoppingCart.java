/**
 *@Title shoppingCart
 *@Description 购物车类
 *@Author gyw
 *@Date 2022年11月20日上午10:54:30
 */
package nuc.ss.entity;

import java.util.*;

import nuc.ss.exception.CartException;

public class ShoppingCart extends HashMap<Book,Integer>{
    public void add(Book b,int num) throws CartException {
    	// 判断库存
    	if(b.getNumber() >= num) {
    		//判断购物车中是否有这本书，有，修改对应的数量；没有，直接添加；
    		if(this.containsKey(b)) {
    			int newNum = this.get(b) + num;
    			this.replace(b, newNum);
    		} else {
    			this.put(b, num);
    		}
    		//修改书籍的库存
    		b.setNumber(b.getNumber() - num);
    		
    	} else {
    		throw new CartException("库存不足!这本编号为" + b.getId() + ",书名为" + b.getName() + "的书仅剩" + b.getNumber() + "本，请修改购买数量！！！");
    	}

    }
    /**
     * 
     * @return 购物车中的书籍数目
     */
    public int countBookNum() {
    	//相当于遍历
    	int num = 0;
    	Iterator<Integer> iterValue = this.values().iterator();
    	while(iterValue.hasNext()) {
    		num += iterValue.next();
    	}
    	return num;
    }
    
    /**
     * 
     * @return 购物车中书籍的总价
     */
    public float countBookPrice() {
    	//相当于遍历<key,value>,将这本书的总价累加到totalPrice
    	float totalPrice = 0;
    	Iterator<Map.Entry<Book, Integer>> iterEntry = this.entrySet().iterator();
    	while(iterEntry.hasNext()) {
    		Map.Entry<Book, Integer> entry = iterEntry.next();
    		totalPrice += entry.getKey().getPrice() * entry.getValue();
    		
    	}
    	return totalPrice;
    }
    public void printDetails() {
    	//相当于遍历<key,value>
    	Iterator<Map.Entry<Book, Integer>> iterEntry = this.entrySet().iterator();
    	System.out.println("购物车的详情如下：");
    	System.out.println("书名\t\t单价\t\t数量\t\t总价");
    	while(iterEntry.hasNext()) {
    		Map.Entry<Book, Integer> entry = iterEntry.next();
    		System.out.print(entry.getKey().getName() + "\t\t");
    		System.out.print(entry.getKey().getPrice() + "\t\t");
    		System.out.print(entry.getValue() + "\t\t");
    		System.out.println(entry.getKey().getPrice() * entry.getValue());
    	}
    	System.out.println(this.toString());
    }
    
	@Override
    public String toString() {
    	return "购物车中共有" + countBookNum() + "本书，共花费" + countBookPrice();    	
    }
}
