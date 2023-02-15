package chap09;

public class Mouse implements USB {
    private String name;

    public Mouse(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println(name + "成功连接了电脑");
    }

    public void dbClick() {
        System.out.println(name + "一键三连");
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
