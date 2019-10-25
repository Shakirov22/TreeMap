package edu.BinaryTree;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class TreeMap<Key extends Comparable<Key>, Value> implements java.util.Map<Key, Value> {
    protected BinaryTree<Key, Value> binaryTree;

    TreeMap() {
        this.binaryTree = new BinaryTree<>();
    }

    @Override
    public int size() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return this.binaryTree.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.binaryTree.containsKey((Key) key);
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Value get(Object key) {
        return this.binaryTree.get((Key) key);
    }

    @Override
    public Value put(Key key, Value value) {
        Value previousValue = this.binaryTree.get(key);
        this.binaryTree.add(key, value);
        return previousValue;
    }

    @Override
    public Value remove(Object key) {
        Value previousValue = this.binaryTree.get((Key) key);
        this.binaryTree.delete((Key) key);
        return previousValue;
    }

    @Override
    public void putAll(Map<? extends Key, ? extends Value> m) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public Set<Key> keySet() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public Collection<Value> values() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public Set<Entry<Key, Value>> entrySet() {
        throw new java.lang.UnsupportedOperationException();
    }
}
