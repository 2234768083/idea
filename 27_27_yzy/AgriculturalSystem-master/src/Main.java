public class Main {
    public static void main(String[] args) {
        // 创建数据库操作对象
        DatabaseOperation db = new DatabaseOperation();
        // 插入农副产品交易信息
        AgriculturalProductTrading trading1 = new AgriculturalProductTrading("apple", 100, 10.5f);
        db.insert(trading1);
        AgriculturalProductTrading trading2 = new AgriculturalProductTrading("banana", 200, 20.0f);
        db.insert(trading2);
        // 查询农副产品交易信息
        AgriculturalProductTrading trading = db.query("apple");
        System.out.println(trading.getName() + " " + trading.getVolume() + " " + trading.getPrice() + " " + trading.getTotalPrice());
        // 更新农副产品交易信息
        trading.setVolume(150);
        trading.setPrice(15.0f);
        db.update(trading);
        // 删除农副产品交易信息
        db.delete("banana");
    }
}