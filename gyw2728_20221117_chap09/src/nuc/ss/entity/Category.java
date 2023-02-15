/**
 *@Title Category
 *@Description
 *@Author gyw
 *@Date 2022年11月20日上午10:41:39
 */
package nuc.ss.entity;

public class Category {
    private int id;
    private String firstLevel;
    private String secondLevel;
	/**
	 * @param id
	 * @param firstLevel
	 * @param secondLevel
	 */
	public Category(int id, String firstLevel, String secondLevel) {
		super();
		this.id = id;
		this.firstLevel = firstLevel;
		this.secondLevel = secondLevel;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the firstLevel
	 */
	public String getFirstLevel() {
		return firstLevel;
	}
	/**
	 * @param firstLevel the firstLevel to set
	 */
	public void setFirstLevel(String firstLevel) {
		this.firstLevel = firstLevel;
	}
	/**
	 * @return the secondLevel
	 */
	public String getSecondLevel() {
		return secondLevel;
	}
	/**
	 * @param secondLevel the secondLevel to set
	 */
	public void setSecondLevel(String secondLevel) {
		this.secondLevel = secondLevel;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", firstLevel=" + firstLevel + ", secondLevel=" + secondLevel + "]";
	}
    
    
}
