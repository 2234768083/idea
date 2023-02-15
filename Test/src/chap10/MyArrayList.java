package chap10;

public class MyArrayList extends MyAbstractList{

    public static final int CAPACITY = 50;
    private Object[] data = new Object[CAPACITY];

    public MyArrayList() {}

    public MyArrayList(Object[] data) {
        super(data);
    }

    @Override
    public void add(int index, Object e) {
        for(int i=size-1; i>=index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public boolean contains(Object e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int indexOf(Object e) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int lastIndexOf(Object e) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void replace(int index, Object e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void clear() {


    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("[");
        for (int i=0; i<size; i++) {
            result.append(data[i]);
            if (i < size-1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }



}
