package link;

import list.AbstractList;

public class TrollLinkList<E> extends AbstractList<E> {
    private int size;
    private TrollNode<E> first;
    private TrollNode<E> last;

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public void add(E e) {
        add(size, e);
    }

    @Override
    public E get(int position) {
        return node(position).element;
    }

    @Override
    public void set(E e) {

    }

    public void set(int position, E e) {
        TrollNode<E> n = node(position);
        n.element = e;
    }

    @Override
    public void add(int position, E e) {
        if (position == 0) {
            first = new TrollNode<>(e, null, null);

        } else {
            TrollNode<E> positionNode = node(position);
            TrollNode<E> prev = positionNode.prev;
            TrollNode<E> node = new TrollNode<>(e, positionNode, prev);
            positionNode.prev = node;
            prev.next = node;
        }
    }


    public TrollNode<E> node(int index) {

        TrollNode<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }


    private static class TrollNode<E> {
        E element;
        TrollNode<E> next;
        TrollNode<E> prev;

        public TrollNode(E element, TrollNode<E> next, TrollNode<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
