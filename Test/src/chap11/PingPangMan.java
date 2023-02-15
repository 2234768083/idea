package chap11;

public class PingPangMan implements SportMan {
    private String name;
    public PingPangMan(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "必须跑步训练！");
    }

    @Override
    public void competition() {
        System.out.println(name + "要参加比赛，为国争光！");
    }

    @Override
    public void rule() {
        System.out.println(name + "必须守法");
    }

    @Override
    public void eat() {
        System.out.println(name + "要适量吃东西");
    }

    @Override
    public void sleep() {
        System.out.println(name + "要休息好");
    }
}
