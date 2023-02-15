package yzy2727_221106_exp10.nuc.ss.singleton;

import java.util.Scanner;

public class IdentityCardNumber {
    private static IdentityCardNumber instance;

    private static String no;

    private IdentityCardNumber() {}

    static IdentityCardNumber getInstance() {
        if (instance == null) {
            instance = new IdentityCardNumber();
            System.out.println("这是第一次办理身份证，请提供一个身份证号：");
            Scanner sc = new Scanner(System.in);
            no = sc.next();
        }else {
            System.out.println("这不是你第一次办理身份证，请使用以前身份证号：" +  no);
        }
        return instance;
    }
    public String getNo () {
        return no;
    }


}
