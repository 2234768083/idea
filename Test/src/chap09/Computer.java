package chap09;

public class Computer {
    private String name;

    public Computer(String name) {
        this.name = name;
    }

    public void start() {
        System.out.println(name = "开机了");
    }


    public void installUSB(USB usb) {
        // 多态：USB == 可能是鼠标，也可能是键盘
        usb.connect();

        if (usb instanceof KeyBoard){
            KeyBoard k = (KeyBoard) usb;
            k.keyDown();
        }else if (usb instanceof Mouse){
            Mouse m = (Mouse) usb;
            m.dbClick();
        }

        usb.uncommect();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
