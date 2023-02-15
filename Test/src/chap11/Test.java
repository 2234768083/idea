package chap11;

public class Test {
    public static void main(String[] args) {
        PingPangMan p = new PingPangMan("张继科");
        BasketBallMan b = new BasketBallMan("科比");
        p.run();
        p.competition();
        b.eat();
        b.competition();
        b.rule();
        b.sleep();
    }
}
