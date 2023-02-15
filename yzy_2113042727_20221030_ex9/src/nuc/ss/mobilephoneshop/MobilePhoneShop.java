package nuc.ss.mobilephoneshop;

public class MobilePhoneShop {
    private int mobilePhoneAmount;
    private double mobilePhonePrice;
    private InHouseCoupon[] ihc1;
    private InHouseCoupon[] ihc2;

    public MobilePhoneShop(int mobilePhoneAmount, double mobilePhonePrice) {
        this.mobilePhoneAmount = mobilePhoneAmount;
        this.mobilePhonePrice = mobilePhonePrice;
    }

    public int getMobilePhoneAmount() {
        return mobilePhoneAmount;
    }

    public void setMobilePhoneAmount(int mobilePhoneAmount) {
        this.mobilePhoneAmount = mobilePhoneAmount;
    }

    public double getMobilePhonePrice() {
        return mobilePhonePrice;
    }

    public void setMobilePhonePrice(double mobilePhonePrice) {
        this.mobilePhonePrice = mobilePhonePrice;
    }

    public InHouseCoupon[] getIhc1() {
        return ihc1;
    }

    public InHouseCoupon[] getIhc2() {
        return ihc2;
    }

    /**
     * @param num        购物卡的数量，编号从0开始，顺序往后编
     * @param moneyValue 购物卡的面值
     */


    public void madeFirstCoupon(int num, double moneyValue) {
        ihc1 = new InHouseCoupon[num];
        for (int i = 0; i < num; i++) {
            ihc1[i] = new InHouseCoupon(i, moneyValue);

        }
    }

    @Override
    public String toString() {
        // 现在手机商店里有多少部手机xxx部手机，每部手机市场价为xxx元。
        return "现在手机专卖店有" + mobilePhoneAmount + "部手机，每部手机市场价为" + mobilePhonePrice + '元';
    }

    /**
     * @param num        购物卡的数量，编号随机生成
     * @param moneyValue 购物卡的面值
     */
    public void madeSecondCoupon(int num, double moneyValue) {
        ihc2 = new InHouseCoupon[num];
        for (int i = 0; i < num; i++) {
            ihc2[i] = new InHouseCoupon(IdGenerator.getNextId(num), moneyValue);

        }
    }

    class InHouseCoupon {
        private int id;
        private double moneyValue;

        public InHouseCoupon(int id, double moneyValue) {
            super();
            this.id = id;
            this.moneyValue = moneyValue;
        }

        @Override
        public String toString() {
            // 内部购物券（编号:***,金额：***）
            return "内部购物券（编号：" + id + ", 金额" + moneyValue;
        }

        public void buyMobilePhone() {
            if (moneyValue >= mobilePhonePrice) {
                // 恭喜！您用内部购物券(编号：金额）可以购买手机！使用后还剩***元
                System.out.println("恭喜！您用" + this.toString() + "可以购买手机！使用后还剩" + (moneyValue - mobilePhonePrice) + "元。");
            } else {
                // 对不起！您的购物券(编号：xxx)价值不足！
                System.out.println("对不起！您用" + this.toString() + "不够购买手机，还需支付" + (mobilePhonePrice = moneyValue));
            }

            mobilePhoneAmount--;

        }
    }

}
