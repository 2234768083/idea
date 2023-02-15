package nuc.ss.thread;
// 测试多线程程序的运行
public class TestMultiThread {
    public static void main(String[] args) {
        // 线程类对象的第一种创建方式
        PrintEnglishThread t1 = new PrintEnglishThread();
        // 启动线程
        t1.start();
        // 线程类对象的第二种创建方式
        Thread t2 = new Thread(new PrintChineseThread());
        // 启动线程
        t2.start();
    }
}
