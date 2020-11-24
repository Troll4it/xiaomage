package circle;

import org.omg.CORBA.Object;

public class TrollCircleDeque<E> {
    private int size;
    private E[] elements;

    private int first = 0;
    private int end = 0;

    public TrollCircleDeque() {
        elements = (E[]) new Object[10];
    }

    public int size() {
        return elements.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offerEnd(E e) {
        ensureCapacity(size);
        elements[(first + size) % elements.length] = e;
        size++;
    }

    public void offerFirst(E e) {
        ensureCapacity(size);
        first = index(-1);
        elements[first] = e;
        size++;
    }

    private int index(int index) {
        index += first;
        if (index < 0) {
            return index + elements.length;
        }
        return (index + first) % elements.length;
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

    public E pollFirst() {
        E firstElement = elements[first];
        elements[first] = null;
        first = (first + 1) % elements.length;
        size--;
        return firstElement;
    }


    public E pollEnd() {
        int end = first + size - 1;
        E endElement = elements[end];
        elements[end] = null;
        first = (end - 1) % elements.length;
        size--;
        return endElement;
    }

    public E front() {
        return elements[first];
    }
}
