package ua.nure.garmash.Practice6;

public class Tree<E extends Comparable<E>> {

    private static final String INDENT = "   ";

    private Node<E> root = null;

    public boolean remove(E element) {
        return false;
    }

    public void add(E[] elements) {

    }

    public boolean add(E value) {
        if (root == null) {
            root = new Node<>(value);
        }
        Node<E> temp = new Node<>(value);
        if (root.value.compareTo(value)>0) {
            root.leftChild = temp;
        } else {

        }
        return false;
    }

    public void print() {

    }

    private static class Node<E> {
        E value;
        Node leftChild;
        Node rightChild;

        Node(E value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }

        public E getValue() {
            return value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }
    }

}
