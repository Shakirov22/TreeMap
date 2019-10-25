package edu.BinaryTree;

public class Node<Key extends Comparable<Key>, Value> {
    private int height;
    private Node<Key, Value> leftChild;
    private Node<Key, Value> rightChild;
    private Node<Key, Value> parent;
    private Key key;
    private Value value;

    public Node(Key key, Value value, Node<Key, Value> parent) {
        this.key = key;
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = parent;
        this.height = 1;
    }

    public int getHeight() {
        return this.height;
    }

    public Node<Key, Value> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(Node<Key, Value> node) {
        this.leftChild = node;
    }

    public Node<Key, Value> getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(Node<Key, Value> node) {
        this.rightChild = node;
    }

    public Node<Key, Value> getParent() {
        return this.parent;
    }

    public void setParent(Node<Key, Value> node) {
        this.parent = node;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    private int getLeftHeight() {
        return ((this.leftChild != null) ? this.leftChild.getHeight() : 0);
    }

    private int getRightHeight() {
        return ((this.rightChild != null) ? this.rightChild.getHeight() : 0);
    }

    public int updateHeight() {
        int leftHeight = this.getLeftHeight();
        int rightHeight = this.getRightHeight();
        return this.height = ((leftHeight > rightHeight) ? leftHeight : rightHeight) + 1;
    }

    public int getBalance() {
        int leftHeight = this.getLeftHeight();
        int rightHeight = this.getRightHeight();
        return leftHeight - rightHeight;
    }
}