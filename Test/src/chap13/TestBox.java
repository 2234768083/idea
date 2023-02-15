package chap13;
public class TestBox {
    public static void main(String[] args) {
        Box b1 = new Box(10);
        Box b2 = new Box(10,20,30);
        System.out.println("�����������"+b1.getVolume());
        System.out.println("�����������"+b2.getVolume());
    }
    public static class Box {
        private float length;
        private float width;
        private float height;
        //����������ĺ���
        Box(float side){
            length = side;
            width = side;
            height = side;
        }
        //���쳤����ĺ���
        Box(float length,float width,float height){
            this.length = length;
            this.width = width;
            this.height = height;
        }
        public float getVolume() {
            return length * width * height;
        }
    }

}
