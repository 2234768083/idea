package nuc.ss.ticket;

public class Ticket {
    private int num;// 票的数量

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * @param num
     */
    public Ticket(int num) {
        super();
        this.num = num;
    }
}