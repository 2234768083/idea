package yzy2727_221106_exp10.nuc.ss.singleton;


public class TestIdentityCard {
    public static void main(String[] args) {

        // 第一次办理
        IdentityCardNumber number1 = IdentityCardNumber.getInstance();

        // 补办
        IdentityCardNumber number2 = IdentityCardNumber.getInstance();

        // 补办
        IdentityCardNumber number3 = IdentityCardNumber.getInstance();
    }
}
