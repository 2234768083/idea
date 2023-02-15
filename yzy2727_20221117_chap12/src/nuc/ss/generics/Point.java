/**
 *@Title Point
 *@Description 泛型类
 *@Author gyw
 *@Date 2022年11月17日上午10:15:56
 */
package nuc.ss.generics;

public class Point <T>{
    private T x,y;

	/**
	 * @param x 坐标1
	 * @param y 坐标2
	 */
	public Point(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public T getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(T x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public T getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(T y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
    
}
