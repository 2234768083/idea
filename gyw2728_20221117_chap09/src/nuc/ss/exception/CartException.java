/**
 *@Title CartException
 *@Description 购物车异常类
 *@Author gyw
 *@Date 2022年11月20日上午10:51:17
 */
package nuc.ss.exception;

public class CartException extends Exception{
    private String info = "购物车异常!!!";
    
    public CartException() {}
    
    public CartException(String info) {
    	this.info = info;
    }

	@Override
	public String toString() {
		return "info";
	}    
}
