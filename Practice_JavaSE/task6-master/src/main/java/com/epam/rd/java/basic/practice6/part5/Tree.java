package com.epam.rd.java.basic.practice6.part5;

/**
 * Class Tree for Task 5.
 * @param <E>
 */
public class Tree<E extends Comparable<E>> {
    private Node<E> root;
    private Node<E> parent;
    private Node<E> current;

    public void add(E[] elements) {
        for (int i = 0; i < elements.length; i++) {
            add(elements[i]);
        }
    }

    public boolean add(E elements) {
        if (root == null) {
            root = new Node<>(elements, null, null);
            return true;
        }
        return add(root, elements);
    }

    public boolean add(Node<E> node, E elements) {
        if (elements.compareTo(node.key) < 0) {
            leftAdd(node, elements);
            return true;
        } else if (elements.compareTo(node.key) > 0) {
            rightAdd(node, elements);
            return true;
        }
        return false;
    }

    public boolean leftAdd(Node<E> node, E elements) {
        if (node.left == null) {
            node.left = new Node<>(elements, null, null);
            return true;
        }
        return add(node.left, elements);
    }

    public boolean rightAdd(Node<E> node, E elements) {
        if (node.right == null) {
            node.right = new Node<>(elements, null, null);
            return true;
        }
        return add(node.right, elements);
    }


    public boolean remove(E element) {
        final int left = -1;
        final int right = 1;
        int step = 0;
        parent = null;
        current = root;

        step = removeCurrent(element, right, step);
        if (current == null) {
            return false;
        }

        if (current.left == null) {
            shiftLeft(right, left, step);
        } else if (current.right == null) {
            shiftRight(right, step);
        } else {
            shift();
        }
        return true;
    }

    private int removeCurrent(E element, final int right, int step) {
        int curr;
        while (current != null && (curr = current.key.compareTo(element)) != 0) {
            parent = current;
            if (curr < 0) {
                step = right;
                current = current.right;
            } else {
                step = -1;
                current = current.left;
            }
        }
        return step;
    }

    private void shiftLeft(final int right, final int left, int step) {
        if (step == right) {
            parent.right = current.right;
        } else if (step == left) {
            parent.left = current.right;
        } else {
            root = current.right;
        }
    }

    private void shiftRight(final int right, int lastStep) {
        if (lastStep == right) {
            parent.right = current.left;
        } else if (lastStep == -1) {
            parent.left = current.left;
        } else {
            root = current.left;
        }
    }

    private void shift() {
        Node<E> replace = current.right;
        parent = current;
        while (replace.left != null) {
            parent = replace;
            replace = replace.left;
        }
        current.key = replace.key;
        if (parent.equals(current)) {
            parent.right = replace.right;
        } else {
            parent.left = replace.right;
        }
    }

    public void print() {
        print(root, "");
    }

    private void print(Node<E> current, String id) {
        if (current == null) {
            return;
        }
        print(current.left, id + "  ");
        System.out.println(id + current.key);
        print(current.right, id + "  ");
    }

    /**
     * Class Node.
     * @param <E>
     */
    public static final class Node<E> {
        private E key;
        private Node<E> left;
        private Node<E> right;

        Node(E key, Node<E> left, Node<E> right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }
}
