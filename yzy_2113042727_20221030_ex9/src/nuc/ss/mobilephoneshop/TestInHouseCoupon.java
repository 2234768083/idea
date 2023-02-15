package nuc.ss.mobilephoneshop;

public class TestInHouseCoupon {

    public static void main(String[] args) {
        // 创建一个手机商店
        MobilePhoneShop shop = new MobilePhoneShop(12,3000);
        // 输出：现在手机专卖店有xxx部手机，每部手机市场价为xxx元。
        System.out.println(shop);
        // 商品促销制造购物卡
        shop.madeFirstCoupon(50,800);
        shop.madeSecondCoupon(5,3500);

        // 用购物券买手机
        shop.getIhc1()[0].buyMobilePhone();

        shop.getIhc2()[0].buyMobilePhone();

        // 输出：手机专卖店还有xxx部手机!
        System.out.println(shop.getMobilePhoneAmount());

        // 在类外创建内部的对象内部类的对象，内部类是非静态的
        MobilePhoneShop.InHouseCoupon ihc = shop.new InHouseCoupon(IdGenerator.getNextId(1), 800);
        ihc.buyMobilePhone();
    }
}
