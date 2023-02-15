package nuc.ss.mobilephoneshop;

import java.util.Random;

/**
 *
 * @author yzy
 *
 * @description Id生成器
 *
 */
public class IdGenerator {
    public static int getNextId(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }
}
