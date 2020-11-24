package list;

public interface ListImpl<E> {

    int size();

    void clear();

    boolean isEmpty();

    boolean contains(E element);

    void add(E e);

    E get(int position);

    void set(E e);

    void add(int position, E e);
}
