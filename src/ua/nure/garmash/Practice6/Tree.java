package ua.nure.garmash.Practice6;

public class Tree<E extends Comparable<E>> {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(9);
        tree.add(13);
        tree.add(8);
        tree.add(7);
        tree.add(55);
        tree.add(12);
        tree.add(59);
        tree.add(-2);
        tree.add(-3);
        tree.add(-5);
        System.out.println(tree.toString());
    }

    @Override
    public String toString() {
        return root.toString();
    }

    private Node<E> root = null;

    public boolean remove(E element) {
        return false;
    }

    public void add(E[] elements) {

    }

    public boolean add(E value) {
        return (addRecursively(root, value));
    }

    private boolean addRecursively(Node<E> currentNode, E value) {
        if (root == null) {
            root = new Node<>(value);
            return true;
        }
        if (currentNode.value.equals(value)) {
            System.out.println("Duplicate value " + value + " already exists int the tree");
            return false;
        }
        Node<E> toBeAdded = new Node<>(value);
        if (currentNode.value.compareTo(value) > 0) {  //8>3
            if (currentNode.leftChild == null) {
                currentNode.leftChild = toBeAdded;
            } else {
                addRecursively(currentNode.leftChild, value);
            }
        } else {
            if (currentNode.rightChild == null) {
                currentNode.rightChild = toBeAdded;
            } else {
                addRecursively(currentNode.rightChild, value);
            }
        }
        return true;
    }

    private static class Node<E> {
        E value;
        Node<E> leftChild;
        Node<E> rightChild;

        Node(E value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }

        public E getValue() {
            return value;
        }

        public Node<E> getLeftChild() {
            return leftChild;
        }

        public Node<E> getRightChild() {
            return rightChild;
        }

        @SuppressWarnings("ResultOfMethodCallIgnored")
        public StringBuilder toString(StringBuilder prefix, StringBuilder sb) {
            if (rightChild != null) {
                rightChild.toString(new StringBuilder().append(prefix).append("\t"), sb);
            }
            sb.append(prefix).append("\t").append(value.toString()).append("\n");
            if (leftChild != null) {
                leftChild.toString(new StringBuilder().append(prefix).append("\t"), sb);
            }
            return sb;
        }

        @Override
        public String toString() {
            return toString(new StringBuilder(), new StringBuilder()).toString();
        }

    }
}
