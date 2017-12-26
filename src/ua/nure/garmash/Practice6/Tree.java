package ua.nure.garmash.Practice6;

public class Tree<E extends Comparable<E>> {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(9);
        tree.add(new Integer[]{8, 15});
        tree.add(12);
        tree.add(11);
        System.out.println(tree.toString());
        tree.remove(10);
        System.out.println("------------------------------------------");
        System.out.println(tree.toString());
    }

    @Override
    public String toString() {
        return root.toString();
    }

    private Node<E> root = null;

    public void add(E[] elements) {
        for (E e : elements) {
            add(e);
        }

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
            System.out.println("Duplicate value. " + value + " already exists int the tree");
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

    public boolean remove(E element) {
        isDeleted = false;
        root = removeRecursively(root, element);
        return isDeleted;
    }

    private Node<E> removeRecursively(Node<E> root, E value) {

        if (root == null) return null;
        //finding node with equal value
        if (root.value.compareTo(value) > 0) {
            root.leftChild = removeRecursively(root.leftChild, value);
        } else if (root.value.compareTo(value) < 0) {
            root.rightChild = removeRecursively(root.rightChild, value);
        } else
        // if key is same as root's key, then This is the node
        // to be deleted
        {
            // node with only one child or no child
            if (root.leftChild == null)
                return root.rightChild;
            else if (root.rightChild == null)
                return root.leftChild;
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.value = getLeftmostVal(root.rightChild);

            // Delete the inorder successor
            root.rightChild = removeRecursively(root.rightChild, root.value);
            isDeleted = true;
        }
        return root;
    }

    private E getLeftmostVal(Node<E> root) {
        E minVal = root.value;
        while (root.leftChild != null) {
            minVal = root.leftChild.value;
            root = root.leftChild;
        }
        return minVal;
    }

    private boolean isDeleted = false;

    private static class Node<E> {
        E value;
        Node<E> leftChild;
        Node<E> rightChild;

        Node(E value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
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
