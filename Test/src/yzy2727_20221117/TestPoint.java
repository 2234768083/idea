package yzy2727_20221117;

public class TestPoint {
    public static void main(String[] args) {

        Point<?> p1 = new Point<Integer>(2, 3);
        System.out.println(p1);

        p1 = new Point<Float>(2.3f, 4.5f);
        System.out.println(p1);

        p1 = new Point<String>("东经23.4","北纬38.7");
        System.out.println(p1);
    }
}
