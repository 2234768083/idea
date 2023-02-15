package chap03;

public class TestBox {
    public static void main(String[] args) {
        Box b1 = new Box(10);
        Box b2 = new Box(10, 20, 30);
        System.out.println("正方体体积：" + b1.getVolume());
        System.out.println("长方体体积：" + b2.getVolume());
    }

    public static class Box {
        private float length;
        private float width;
        private float height;

        //构造正方体的盒子
        Box(float side) {
            length = side;
            width = side;
            height = side;
        }

        //构造长方体的盒子
        Box(float length, float width, float height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }

        public float getVolume() {
            return length * width * height;
        }
    }

}
