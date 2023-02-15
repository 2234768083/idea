package chap04;

public class MyArrayList {
    private String[] data;
    private int size = 0;
    private final int CAPACITY = 100;

    public MyArrayList() {
        data = new String[CAPACITY];
    }

    public MyArrayList(String[] data) {
        super();
        this.data = data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(String s) {
        add(size, s);
    }

    public void add(int index, String s) {
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = s;
        size++;
    }

    public void printALL() {
        for (int i = 0; i < size; i++) {
            System.out.print("[");
            System.out.print(data[i]);
            System.out.print("]");
            if (i < size - 1) {
                System.out.print(",");
            }
        }
    }
}
