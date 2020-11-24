package queue;


import link.TrollLinkList;

/**
 * 双端队列  double ended queue
 */
public class TrollDeque<E> {

    private TrollLinkList<E> list = new TrollLinkList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void offerLast(E e) {
        list.add(e);
    }

    public void offerFirst(E e) {
        list.add(0, e);
    }

    public E pollLast() {
        return list.get(size());
    }

    public E pollFirst() {
        return list.get(0);
    }
}
