package chap11;

public class BasketBallMan implements SportMan {

    private String name;
    public BasketBallMan(String name) {
        this.name = name;
    }

    @Override
    public void rule() {
        System.out.println(name + "必须遵守比赛规则");
    }

    @Override
    public void eat() {
        System.out.println(name + "赛前必须吃东西");
    }

    @Override
    public void sleep() {
        System.out.println(name + "比赛前要充分休息");
    }

    @Override
    public void run() {
        System.out.println(name + "比赛前要进行适当锻炼");
    }

    @Override
    public void competition() {
        System.out.println(name + "要参加比赛，为国争光！");
    }
}
