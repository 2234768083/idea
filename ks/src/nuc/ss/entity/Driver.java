package nuc.ss.entity;

/**
 * @author 2113042703 ����
 * @data
 * @description
 */
public class Driver {
    private String did;
    private String user;
    private String password;
    private String name;
    private String remuneration;  //����
    private String bonus; //������ɣ�
    private String fine;  //���𣨿ۼ����ʣ�
    private String count; //�ϼ�

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(String remuneration) {
        this.remuneration = remuneration;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "˾��{" + "˾����ţ�" + did + ", ˾��������" + name + ", ���꣺" + remuneration + ", ������ɣ���" + bonus + ", ���𣨿ۼ����ʣ���" + fine + ", �ϼƣ�" + count + '}';
    }

}

