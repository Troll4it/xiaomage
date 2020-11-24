package list;

public class TrollList<E> {

    private int size;

    private E[] elements;

    public static int DEFAULT_CAPACITY = 16;

    private int ELEMENT_NOT_FOUND = 0;


    public E get(int index) {
        return elements[index];
    }

    /**
     * 添加元素
     *
     * @param element
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * 将数据从最后一个开始移动，知道index + 1 位置
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(index);
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;

        size++;
    }

    public int size() {
        return size;
    }


    /**
     * 移除将index+1开始移除
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        elements[size] = null;
        return old;
    }

    public E remove(E e) {
//        remove(indexOf(e));
        return e;
    }


    public TrollList() {
        this(DEFAULT_CAPACITY);
    }

    public TrollList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
    }


    /**
     * 申请更大的数组
     * 思维:通过将elements的length与
     * 添加一个更大的数组，然后将原有的数据copy过去
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;

        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + oldCapacity >> 1;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    /**
     * 将elements中的存储的每个都置为null,将循环利用的留下
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }
}
