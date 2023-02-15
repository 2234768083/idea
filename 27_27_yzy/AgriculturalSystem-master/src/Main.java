public class Main {
    public static void main(String[] args) {
        // �������ݿ��������
        DatabaseOperation db = new DatabaseOperation();
        // ����ũ����Ʒ������Ϣ
        AgriculturalProductTrading trading1 = new AgriculturalProductTrading("apple", 100, 10.5f);
        db.insert(trading1);
        AgriculturalProductTrading trading2 = new AgriculturalProductTrading("banana", 200, 20.0f);
        db.insert(trading2);
        // ��ѯũ����Ʒ������Ϣ
        AgriculturalProductTrading trading = db.query("apple");
        System.out.println(trading.getName() + " " + trading.getVolume() + " " + trading.getPrice() + " " + trading.getTotalPrice());
        // ����ũ����Ʒ������Ϣ
        trading.setVolume(150);
        trading.setPrice(15.0f);
        db.update(trading);
        // ɾ��ũ����Ʒ������Ϣ
        db.delete("banana");
    }
}