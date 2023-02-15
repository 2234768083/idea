package nuc.ss.ticket;
// 卖票的窗口
public class SaleTicketWindow extends Thread{
    private Ticket ticket;

    public SaleTicketWindow(Ticket ticket, String name) {
        super(name);
        this.ticket = ticket;
    }

    @Override
    public void run() {
        // 任务：卖票
        synchronized (ticket){
            // 获取票的数目
            int num = ticket.getNum();
            if (num > 0) {
                System.out.println("这是" + Thread.currentThread().getName() + "卖出的" + num + "号票！");
                ticket.setNum(num - 1);
            } else {
                System.out.println("很抱歉，票已卖完！");
            }
        }
    }
}
