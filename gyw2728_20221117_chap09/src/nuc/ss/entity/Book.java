/**
 *@Title Book
 *@Description
 *@Author gyw
 *@Date 2022年11月20日上午10:43:30
 */
package nuc.ss.entity;

public class Book {
    private String id;
    private String name;
    private String author;
    private float price;
    private int number;
    private Category category;
	/**
	 * @param id
	 * @param name
	 * @param author
	 * @param price
	 * @param number
	 * @param category
	 */
	public Book(String id, String name, String author, float price, int number, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.number = number;
		this.category = category;
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
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", number=" + number
				+ ", category=" + category + "]";
	}
    
    @Override
    public boolean equals(Object obj) {
    	if(obj instanceof Book) {
    		Book b = (Book)obj;
    		if(b.getId().equals(this.getId())) {
    			return true;
    		} else {
    			return false;
    		}
    	} else {
    		return false;
    	}
    }
    
    
}
