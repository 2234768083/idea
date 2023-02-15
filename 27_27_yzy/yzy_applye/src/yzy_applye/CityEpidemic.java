package yzy_applye;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CityEpidemic {
    // 城市编号
    private int id;
    // 城市名称
    private String name;
    // 新增人数
    private int newAdd;
    // 现有人数
    private int current;
    // 累计人数
    private int total;
    // 治愈人数
    private int cured;
    // 死亡人数
    private int dead;

    // 构造方法
    public CityEpidemic(int id, String name, int newAdd, int current, int total, int cured, int dead) {
        this.id = id;
        this.name = name;
        this.newAdd = newAdd;
        this.current = current;
        this.total = total;
        this.cured = cured;
        this.dead = dead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNewAdd() {
        return newAdd;
    }

    public void setNewAdd(int newAdd) {
        this.newAdd = newAdd;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCured() {
        return cured;
    }

    public void setCured(int cured) {
        this.cured = cured;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }

    // 使用 FileOutputStream 创建一个文件，用于保存城市疫情信息
    FileOutputStream fos = new FileOutputStream("epidemic.data");

    // 创建三个城市疫情对象，并将它们的信息写入文件
    CityEpidemic beijing = new CityEpidemic(1, "Beijing", 23, 1001, 1234, 45, 12);
    CityEpidemic shanghai = new CityEpidemic(2, "Shanghai", 15, 876, 991, 33, 8);
    CityEpidemic guangzhou = new CityEpidemic(3, "Guangzhou", 12, 765, 888, 29, 7);

// 将城市疫情对象写入文件
        fos.write(beijing.getBytes());
        fos.write(shanghai.getBytes());
        fos.write(guangzhou.getBytes());

// 关闭文件
        fos.close();

    // 使用 FileInputStream 读取文件中保存的城市疫情信息
    FileInputStream fis = new FileInputStream("epidemic.data");

    // 创建一个集合，用于存放城市疫情信息
    List<CityEpidemic> list = new ArrayList<>();

// 读取文件中的城市疫情信息，并存放到集合中
    while(true) {
        // 读取一个城市疫情信息
        CityEpidemic cityEpidemic = fis.readObject();

        // 如果读取到了文件末尾，则退出循环
        if (cityEpidemic == null) {
            break;
        }

        // 将城市疫情信息添加到集合中
        list.add(cityEpidemic);
    }

// 关闭文件
        fis.close();

// 按照死亡人数从小到大排序
        list.sort(new Comparator<CityEpidemic>()

    {
        @Override
        public int compare (CityEpidemic c1, CityEpidemic c2){
        return c1.getDead() - c2.getDead();
    }
    });

// 遍历集合，输出城市疫情信息
        for(
    CityEpidemic cityEpidemic :list)

    {
        System.out.println(cityEpidemic);
    }
}