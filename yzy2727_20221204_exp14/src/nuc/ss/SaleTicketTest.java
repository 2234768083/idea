package nuc.ss;

import nuc.ss.view.SaleTicketFrame;

public class SaleTicketTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new SaleTicketFrame();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                new SaleTicketFrame();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                new SaleTicketFrame();
            }
        }).start();
    }
}
