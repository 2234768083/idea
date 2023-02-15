package com.example.trading;

public class AgriculturalProductTradingDB extends AbstractDB {
    // 数据库连接对象
    private Connection conn;

    // 构造器
    public AgriculturalProductTradingDB(Connection conn) {
        this.conn = conn;
    }

    // 查询农副产品交易信息
    public AgriculturalProductTrading query(String name) {
        // 创建农副产品交易对象
        AgriculturalProductTrading trading = new AgriculturalProductTrading();
        try {
            // 创建PreparedStatement对象，用于执行SQL语句
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM agricultural_product_trading WHERE name = ?");
            // 设置参数
            stmt.setString(1, name);
            // 执行查询语句
            ResultSet rs = stmt.executeQuery();
            // 判断查询结果是否为空
            if (rs.next()) {
                // 将查询结果设置到农副产品交易对象中
                trading.setName(rs.getString("name"));
                trading.setVolume(rs.getInt("volume"));
                trading.setPrice(rs.getInt("price"));
            }
        } catch (SQLException e) {
            // 处理SQL异常
            e.printStackTrace();
        }
        // 返回农副产品交易对象
        return trading;
    }

    // 插入农副产品交易信息
    public void insert(AgriculturalProductTrading trading) {
        try {
            // 创建PreparedStatement对象，用于执行SQL语句
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO agricultural_product_trading (name, volume, price) VALUES (?, ?, ?)");
            // 设置参数
            stmt.setString(1, trading.getName());
            stmt.setInt(2, trading.getVolume());
            stmt.setInt(3, trading.getPrice());
            // 执行插入语句
            stmt.executeUpdate();
        } catch (SQLException e) {