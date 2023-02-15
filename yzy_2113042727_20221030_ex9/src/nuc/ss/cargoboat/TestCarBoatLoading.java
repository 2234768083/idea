package nuc.ss.cargoboat;
/**
 *
 * @Title：
 * @Description：模拟货轮装货
 * @author：yzy
 * @date：2022年10月29日下午9:34:48
 *
 */
public class TestCarBoatLoading {
    public static void main(String[] args) {

        //制造一艘货轮
        CargoBoat boat = new CargoBoat(1000);

        //往货轮上装货
        try {
            boat.loading(100);
            boat.loading(300);
            boat.loading(300);
            boat.loading(400);
        } catch (DangerException dx){
            System.out.println(dx.toString());
        } finally {
            System.out.println("货轮正点启航！");
        }

    }
}
