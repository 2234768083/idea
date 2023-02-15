package nuc.ss.ticket;
// 模拟多窗口卖票
public class TestMultiWindowSaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket(30);
        // 三个卖票窗口
        SaleTicketWindow t1 = new SaleTicketWindow(ticket, "中北窗口");
        SaleTicketWindow t2 = new SaleTicketWindow(ticket, "北大窗口");
        SaleTicketWindow t3 = new SaleTicketWindow(ticket, "清华窗口");


        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
