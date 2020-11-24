package queue;

import link.TrollLinkList;

public class TrollQueue<E> {

    private TrollLinkList<E> list = new TrollLinkList<>();


    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void offer(E e) {
        list.add(e);
    }

    public E poll() {
        return list.get(size());
    }


}
