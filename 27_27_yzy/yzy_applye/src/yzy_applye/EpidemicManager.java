package yzy_applye;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EpidemicManager {
    private List<CityEpidemic> list;

    public EpidemicManager() {
        // 创建一个集合，用于存放城市疫情信息
        list = new ArrayList<>();
    }

    // 添加城市疫情信息
    public void add(CityEpidemic cityEpidemic) {
        list.add(cityEpidemic);
    }

    // 删除城市疫情信息
    public void remove(CityEpidemic cityEpidemic) {
        list.remove(cityEpidemic);
    }

    // 按照死亡人数从小到大的顺序输出城市疫情信息
    public void print() {
        // 按照死亡人数从小到大排序
        list.sort(new Comparator<CityEpidemic>() {
            @Override
            public int compare(CityEpidemic c1, CityEpidemic c2) {
                return c1.getDead() - c2.getDead();
            }
        });

        // 遍历集合，输出城市疫情信息
        for (CityEpidemic cityEpidemic : list) {
            System.out.println(cityEpidemic);
        }
    }

    // 保存城市疫情信息到文件
    public void save() throws IOException {
        // 使用 FileOutputStream 创建一个文件，用于保存城市疫情信息
        FileOutputStream fos = new FileOutputStream("epidemic.data");

        // 将集合中的城市疫情信息写入文件
        for (CityEpidemic cityEpidemic : list) {
            fos.write(cityEpidemic.getBytes());
        }

        // 关闭文件
        fos.close();
    }

    // 从文件中读取城市疫情信息
    public void load() throws IOException, ClassNotFoundException {
        // 使用 FileInputStream 读取文件中保存的城市疫情信息
        FileInputStream fis = new FileInputStream("epidemic.data");

        // 读取文件中的城市疫情信息，并存放到集合中
        while (true) {
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
    }


    // 创建一个疫情管理器
    public static void main(String[] args) {
        EpidemicManager manager = new EpidemicManager();

// 添加城市疫情信息
        manager.add(newCityEpidemic(1, "Beijing", 23, 1001, 1234, 45, 12));
        manager.add(newCityEpidemic(2, "Shanghai", 15, 876, 991, 33, 8));
        manager.add(newCityEpidemic(3, "Guangzhou", 12, 765, 888, 29, 7));

// 保存城市疫情信息到文件
        manager.save();

// 从文件中读取城市疫情信息
        manager.load();

// 按照死亡人数从小到大的顺序输出城市疫情信息
        manager.print();
    }
}

