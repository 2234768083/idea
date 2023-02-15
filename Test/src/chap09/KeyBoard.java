package chap09;

public class KeyBoard implements USB {
    private String name;

    public KeyBoard(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println(name + "成功连接了电脑");
    }

    public void keyDown() {
        System.out.println(name + "敲击了：来了，老弟，666");
    }


    @Override
    public void uncommect() {
        System.out.println(name + "成功从电脑拔出了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
