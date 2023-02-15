package nuc.ss.entity;

/**
 * @author 2113042703 ÍõÎú
 * @data
 * @description
 */
public class Car {
    private String cid;
    private String type;
    private String volume;
    private String state;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cid='" + cid + '\'' +
                ", type='" + type + '\'' +
                ", volume='" + volume + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

