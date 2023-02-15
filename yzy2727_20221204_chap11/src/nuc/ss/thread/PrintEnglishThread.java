package nuc.ss.thread;
// 打印英文的hello world。100次，使用线程的第一种创建方式
public class PrintEnglishThread extends Thread{
    @Override
    public void run() {
        // 打印英文的hello world。100次
        for (int i = 0; i < 100; i++) {
            // 延时
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello World!!!");
        }
    }
}
