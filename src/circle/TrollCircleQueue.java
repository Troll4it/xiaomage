package circle;

import org.omg.CORBA.Object;

public class TrollCircleQueue<E> {
    private int size;
    private E[] elements;

    private int first = 0;
    private int end = 0;

    public TrollCircleQueue() {
        elements = (E[]) new Object[10];
    }

    public int size() {
        return elements.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(E e) {
        ensureCapacity(size);
        elements[(first + size) % elements.length] = e;
        size++;
    }

    private void ensureCapacity(int size) {
        int oldCapacity = elements.length;
        if (oldCapacity >= size) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(i + first) % elements.length];
        }
        first = 0;
        elements = newElements;
    }

    public E poll() {
        E firstElement = elements[first];
        elements[first] = null;
        first = (first + 1) % elements.length;
        size++;
        return firstElement;
    }

    public E front() {
        return elements[first];
    }
}
