/**
 *@Title TestPoint
 *@Description
 *@Author gyw
 *@Date 2022年11月17日上午10:17:52
 */
package nuc.ss.generics;

public class TestPoint {
	public static void main(String[] args) {
	//	Point<Integer> p1 = new Point<Integer>(23,45);
		Point<?> p1 = new Point<Integer>(23,45); //通配符
		System.out.println(p1);
		
		p1 = new Point<Float>(23.4f,45.6f);
		System.out.println(p1);
		
		p1 = new Point<String>("东经23.5","北纬23.7");
		System.out.println(p1);


	}

}
