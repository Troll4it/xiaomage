package list;

public abstract class AbstractList<E> implements ListImpl<E> {
    public int ELEMENT_NOT_FOUND = -1;
    public int size;

    public int size() {
        return size;
    }

    public boolean contains(E e) {
//        return indexOf(e) != ELEMENT_NOT_FOUND;
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}
