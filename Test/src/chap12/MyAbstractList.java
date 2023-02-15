package chap12;

public abstract class MyAbstractList implements MyList{

    protected int size = 0; // 线性表的长度

    public MyAbstractList() {}

    public MyAbstractList(Object[] objects) {
        for (int i=0; i<objects.length; i++) {
            add(objects[i]);;
        }
        size = objects.length;
    }

    @Override
    public void add(Object e) {
        add(size,e);

    }

    @Override
    public boolean remove(Object e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
