package stack;

import list.TrollList;

/**
 *
 */
public class Stack<E> extends TrollList<E> {

    public boolean isEmpty() {
        return false;
    }

    public E pop() {
        return get(size() - 1);
    }

    public void push(E e) {
        add(size() + 1, e);
    }
}
