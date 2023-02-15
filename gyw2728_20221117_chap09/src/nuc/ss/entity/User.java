/**
 *@Title User
 *@Description 电商购物—用户类
 *@Author gyw
 *@Date 2022年11月17日上午10:51:10
 */
package nuc.ss.entity;

public class User {
	private String id;
	private String name;
	private String password;
	private String type;
	private char sex;
	private String city;
	
	//每个用户有一辆购物车
	private ShoppingCart cart;
	
	
	/**
	 * @param id
	 * @param name
	 * @param password
	 * @param type
	 * @param sex
	 * @param city
	 */
	public User(String id, String name, String password, String type, char sex, String city) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
		this.sex = sex;
		this.city = city;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the sex
	 */
	public char getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the cart
	 */
	public ShoppingCart getCart() {
		return cart;
	}
	/**
	 * @param cart the cart to set
	 */
	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", type=" + type + ", sex=" + sex
				+ ", city=" + city + "]";
	}
	
	
	
	
	
	

}
