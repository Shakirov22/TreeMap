package edu.BinaryTree;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    protected Node<Key, Value> root;

    BinaryTree() {
        this.root = null;
    }

    private Node<Key, Value> leftRotation(Node<Key, Value> node) {
        if (node.getRightChild().getRightChild() == null && node.getRightChild().getLeftChild() != null) {
            node.setRightChild(rightRotation(node.getRightChild()));
            return leftRotation(node);
        } else {
            if (node.getRightChild().getLeftChild() == null ||
                    node.getRightChild().getLeftChild().getHeight() <= node.getRightChild().getRightChild().getHeight()) {
                Node<Key, Value> newNode = node.getRightChild();
                newNode.setParent(node.getParent());
                node.setRightChild(newNode.getLeftChild());
                if (node.getRightChild() != null)
                    node.getRightChild().setParent(node);
                node.updateHeight();
                node.setParent(newNode);
                node.getBalance();
                newNode.setLeftChild(node);
                newNode.getBalance();
                newNode.updateHeight();
                return newNode;
            } else {
                node.setRightChild(rightRotation(node.getRightChild()));
                return leftRotation(node);
            }
        }
    }


    private Node<Key, Value> rightRotation(Node<Key, Value> node) {
        if (node.getLeftChild().getLeftChild() == null && node.getLeftChild().getRightChild() != null) {
            node.setLeftChild(leftRotation(node.getLeftChild()));
            return rightRotation(node);
        } else {
            if (node.getLeftChild().getRightChild() == null ||
                    node.getLeftChild().getRightChild().getHeight() <= node.getLeftChild().getLeftChild().getHeight()) {
                Node<Key, Value> newNode = node.getLeftChild();
                newNode.setParent(node.getParent());
                node.setLeftChild(newNode.getRightChild());
                if (node.getLeftChild() != null)
                    node.getLeftChild().setParent(node);
                node.updateHeight();
                node.setParent(newNode);
                node.getBalance();
                newNode.setRightChild(node);
                newNode.getBalance();
                newNode.updateHeight();
                return newNode;
            } else {
                node.setLeftChild(leftRotation(node.getLeftChild()));
                return rightRotation(node);
            }
        }
    }

    private Node<Key, Value> balanceNode(Node<Key, Value> node) {
        node.updateHeight();
        int balance = node.getBalance();
        if (balance == -2) {
            node = leftRotation(node);
        } else if (balance == 2) {
            node = rightRotation(node);
        }
        return node;
    }

    private Node<Key, Value> nodeWithMinKey(Node node) {
        if (node.getLeftChild() == null) return node;
        return nodeWithMinKey(node.getLeftChild());
    }

    private Node<Key, Value> add(Node<Key, Value> node, Key key, Value value, Node<Key, Value> parent) {
        if (node == null) {
            return new Node<Key, Value>(key, value, parent);
        }
        int compareResult = key.compareTo(node.getKey());
        if (compareResult > 0) {
            node.setRightChild(add(node.getRightChild(), key, value, node));
            node.updateHeight();
        } else {
            if (compareResult < 0) {
                node.setLeftChild(add(node.getLeftChild(), key, value, node));
                node.updateHeight();
            } else {
                node.setValue(value);
            }
        }
        node = this.balanceNode(node);
        return node;
    }

    public void add(Key key, Value value) {
        this.root = add(this.root, key, value, null);
    }

    private Node<Key, Value> deleteFromRightPosition(Node<Key, Value> node) {
        if (node.getRightChild() == null && node.getLeftChild() == null) {
            node = null;
        } else {
            if (node.getRightChild() == null) {
                node.getLeftChild().setParent(node.getParent());
                node = node.getLeftChild();
            } else {
                if (node.getLeftChild() == null) {
                    node.getRightChild().setParent(node.getParent());
                    node = node.getRightChild();
                } else {
                    if (node.getRightChild().getLeftChild() == null) {
                        node.getRightChild().setLeftChild(node.getLeftChild());
                        node.getRightChild().setParent(node.getParent());
                        node.getLeftChild().setParent(node.getRightChild());
                        node = node.getRightChild();
                    } else {
                        Node<Key, Value> res = nodeWithMinKey(node.getRightChild());
                        node.setKey(res.getKey());
                        node.setValue(res.getValue());
                        node.setRightChild(delete(node.getRightChild(), node.getKey()));
                    }
                }
            }
        }
        return node;
    }

    private Node<Key, Value> delete(Node<Key, Value> node, Key key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.getKey());
        if (compareResult > 0) {
            node.setRightChild(delete(node.getRightChild(), key));
        } else {
            if (compareResult < 0) {
                node.setLeftChild(delete(node.getLeftChild(), key));
            } else {
                node = deleteFromRightPosition(node);
            }
        }
        if (node != null) {
            node = this.balanceNode(node);
        }
        return node;
    }

    public void delete(Key key) {
        this.root = delete(this.root, key);
    }

    private Node<Key, Value> getNode(Node<Key, Value> node, Key key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.getKey());
        if (compareResult == 0) {
            return node;
        } else {
            if (compareResult > 0) {
                return getNode(node.getRightChild(), key);
            } else {
                return getNode(node.getLeftChild(), key);
            }
        }
    }

    public Value get(Key key) {
        Node<Key, Value> node = getNode(root, key);
        return node != null ? node.getValue() : null;
    }

    public boolean containsKey(Key key) {
        return getNode(root, key) != null;
    }


    public boolean isEmpty() {
        return this.root == null;
    }
}
