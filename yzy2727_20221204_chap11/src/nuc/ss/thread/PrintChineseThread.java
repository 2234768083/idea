package nuc.ss.thread;
// 打印“你好，世界”，100次，使用线程类的第一种实现方式
public class PrintChineseThread implements Runnable{
    @Override
    public void run() {
        // 打印“你好，世界”，100次
        for (int i = 0; i < 100; i++) {
            // 延时一段时间
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("你好，世界!!!");
        }
    }
}
