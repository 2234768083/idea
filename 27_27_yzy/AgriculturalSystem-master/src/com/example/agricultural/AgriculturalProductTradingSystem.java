package com.example.agricultural;

public class AgriculturalProductTradingSystem {

    // 声明一个农副产品交易类
    public class AgriculturalProductTrading {
        // 农副产品名称
        private String name;
        // 交易量
        private int volume;
        // 交易价格
        private float price;

        // 定义构造方法
        public AgriculturalProductTrading(String name, int volume, float price) {
            this.name = name;
            this.volume = volume;
            this.price = price;
        }

        // 定义访问器和修改器
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getVolume() {
            return volume;
        }
        public void setVolume(int volume) {
            this.volume = volume;
        }
        public float getPrice() {
            return price;
        }
        public void setPrice(float price) {
            this.price = price;
        }

        // 定义一个方法，用于计算总价
        public float getTotalPrice() {
            return volume * price;
        }
    }

    // 声明一个数据库操作类
    public class DatabaseOperation {
        // 数据库连接
        private Connection conn;

        // 定义构造方法
        public DatabaseOperation() {
            // 使用JDBC API来连接数据库
            try {
                // 加载数据库驱动程序
                Class.forName("com.mysql.jdbc.Driver");
                // 获取数据库连接
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agricultural", "username", "password");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 定义一个方法，用于查询农副产品交易信息
        public AgriculturalProductTrading query(String name) {
            AgriculturalProductTrading trading = null;
            try {
                // 创建一个Statement对象，用于执行SQL语句
                Statement stmt = conn.createStatement();
                // 执行查询语句，获取结果集
                ResultSet rs = stmt.executeQuery("SELECT * FROM agricultural_product WHERE name = '" + name + "'");
                // 判断结果集中是否有数据
                if (rs.next()) {
                    // 获取结果集中的数据
                    String name = rs.getString("name");
                    int volume = rs.getInt("volume");
                    float price = rs.getFloat("price");
                    // 根据数据创建农副产品交易对象
                    trading = new AgriculturalProductTrading(name, volume, price);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // 返回农副产品交易对象
            return trading;
        }

// 定义一个方法，用于插入农副产品交易信息
        public void insert(AgriculturalProductTrading trading) {
            try {
                // 创建一个PreparedStatement对象，用于执行SQL语句
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO agricultural_product(name, volume, price) VALUES(?, ?, ?)");
                // 为SQL语句中的参数赋值
                pstmt.setString(1, trading.getName());
                pstmt.setInt(2, trading.getVolume());
                pstmt.setFloat(3, trading.getPrice());
                // 执行插入语句
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 定义一个方法，用于更新农副产品交易信息
        public void update(AgriculturalProductTrading trading) {
            try {
                // 创建一个PreparedStatement对象，用于执行SQL语句
                PreparedStatement pstmt = conn.prepareStatement("UPDATE agricultural_product SET volume = ?, price = ? WHERE name = ?");
                // 为SQL语句中的参数赋值
                pstmt.setInt(1, trading.getVolume());
                pstmt.setFloat(2, trading.getPrice());
                pstmt.setString(3, trading.getName());
                // 执行更新语句
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 定义一个方法，用于删除农副产品交易信息
        public void delete(String name) {
            try {
                // 创建一个Statement对象，用于执行SQL语句
                Statement stmt = conn.createStatement();
                // 执行删除语句
                stmt.executeUpdate
