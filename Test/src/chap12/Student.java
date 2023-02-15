package chap12;

public class Student {

    private String no;
    private String name;
    public Student(String no, String name) {
        super();
        this.no = no;
        this.name = name;
    }
    public String toString() {
        return "Student [no=" + no + ", name=" + name + "]";
    }
}
