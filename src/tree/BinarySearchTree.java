package tree;

import java.util.Comparator;

/**
 * 二叉搜索树
 */
public class BinarySearchTree<E> {

    private int size;
    private Node<E> root;
    private Comparator<E> comparable;

    public BinarySearchTree(Comparator<E> comparable) {
        this.comparable = comparable;
    }

    public BinarySearchTree() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E element) {
        elementNodeNullCheck(element);
        if (root == null) {
            root = new Node<>(element, null);
        } else {
            Node<E> node = root;
            Node<E> parent = root;
            int cmp = 0;
            while (node != null) {
                cmp = compare(node.e, element);
                parent = node;
                if (cmp > 0) {
                    node = node.right;
                } else if (cmp < 0) {
                    node = node.left;
                } else if (cmp == 0) {
                    return;
                }
            }
            if (cmp > 0) {
                parent.right = new Node<>(element, parent);
            } else if (cmp < 0) {
                parent.left = new Node<>(element, parent);
            } else {
                return;
            }
            size++;

        }
    }

    /**
     * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
     */
    private int compare(E e1, E e2) {
        if (comparable != null) {
            return comparable.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
    }

    private void elementNodeNullCheck(E e) {
        if (e == null)
            throw new IllegalArgumentException("Element is Null");
    }

    private static class Node<E> {
        E e;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E e, Node<E> parent) {
            this.e = e;
            this.parent = parent;
        }
    }
}
