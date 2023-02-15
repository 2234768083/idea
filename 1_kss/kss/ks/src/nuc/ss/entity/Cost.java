package nuc.ss.entity;

/**
 * @author 2113042703 ÍõÎú
 * @data
 * @description
 */

/**
 * cid char(20),
 *     introduce char(20),
 *     time char(20),
 *     name char(20),
 *     allCard char(20),
 */
public class Cost {
    private String cid;
    private String introduce;
    private String time;
    private String name;
    private String allCard;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllCard() {
        return allCard;
    }

    public void setAllCard(String allCard) {
        this.allCard = allCard;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "cid='" + cid + '\'' +
                ", introduce='" + introduce + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", allCard='" + allCard + '\'' +
                '}';
    }
}

