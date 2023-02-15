package nuc.ss.entity;

/**
 * @author 2113042703 ÍõÎú
 * @data
 * @description
 */

/**
 * oid char(20),
 *     name char(20),
 *     price char(20),
 *     remainprice char(20),
 */
public class Oilcard {
    private String oid;
    private String name;
    private String price;
    private String remainprice;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRemainprice() {
        return remainprice;
    }

    public void setRemainprice(String remainprice) {
        this.remainprice = remainprice;
    }

    @Override
    public String toString() {
        return "Oilcard{" +
                "oid='" + oid + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", remainprice='" + remainprice + '\'' +
                '}';
    }
}

