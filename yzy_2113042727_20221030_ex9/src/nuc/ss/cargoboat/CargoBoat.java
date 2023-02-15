package nuc.ss.cargoboat;
/**
 *
 * @Title：
 * @Description：货轮类
 * @author：yzy
 * @date：2022年10月29日下午9:34:48
 *
 */
public class CargoBoat {
    private int realContent = 0;
    private int maxContent;

    public CargoBoat() {}

    /**
     *
     * @param maxContent 最大承载量
     */
    public CargoBoat(int maxContent) {
        this.maxContent = maxContent;

    }

    /**
     * 装货的方法
     * @param m 集装箱的重量
     */
    public void loading(int m) throws DangerException{
        realContent += m;
        if (realContent > maxContent) {
            throw new DangerException("超重！！！你本次只能装载" + (m - realContent + maxContent) + "吨的集装箱");
        }
        System.out.println("目前货轮已装载" + realContent + "吨的货物！");
    }
}
