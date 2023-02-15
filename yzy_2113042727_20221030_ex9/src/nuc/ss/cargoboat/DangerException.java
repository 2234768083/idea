package nuc.ss.cargoboat;

import java.awt.event.WindowFocusListener;

/**
 *
 * @Title：
 * @Description：自定义异常：货轮超重异常
 * @author：yzy
 * @date：2022年10月29日下午9:34:48
 *
 */

public class DangerException extends Exception {
    String info = "超重！！！";

    public DangerException() {}

    public DangerException(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "危险！！！" + info;
    }
}
