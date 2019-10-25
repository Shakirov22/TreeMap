package edu.BinaryTree;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTester {

    private boolean binTreeCheck(Node node) {
        if (node != null) {
            boolean ret = this.binTreeCheck(node.getLeftChild());
            if (!ret) {
                return false;
            }
            ret = this.binTreeCheck(node.getRightChild());
            if (!ret) {
                return false;
            }
            node.updateHeight();
            int balance = node.getBalance();
            boolean cmpCheck =
                    ((node.getLeftChild() == null) || node.getKey().compareTo(node.getLeftChild().getKey()) > 0) &&
                            ((node.getRightChild() == null) || node.getKey().compareTo(node.getRightChild().getKey()) < 0);
            return ((balance < 2) && (balance > -2) && cmpCheck);
        } else {
            return true;
        }
    }

    private boolean binTreeCheck(BinaryTree binaryTree) {
        return binTreeCheck(binaryTree.root);
    }

    private HashMap binaryTreeToHashMap(Node node) {
        if (node != null) {
            HashMap map = new HashMap();
            map.put(node.getKey(), node.getValue());
            map.putAll(binaryTreeToHashMap(node.getLeftChild()));
            map.putAll(binaryTreeToHashMap(node.getRightChild()));
            return map;
        } else {
            return new HashMap();
        }
    }

    protected HashMap binaryTreeToHashMap(BinaryTree binaryTree) {
        return binaryTreeToHashMap(binaryTree.root);
    }

    @Test
    public void testIntegerKeyIntegerValueWithKeys41356AndValues12345() {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        BinaryTree<Integer, Integer> binaryTree = new BinaryTree<Integer, Integer>();
        hashMap.put(4, 1);
        binaryTree.add(4, 1);
        hashMap.put(1, 2);
        binaryTree.add(1, 2);
        hashMap.put(3, 3);
        binaryTree.add(3, 3);
        hashMap.put(5, 4);
        binaryTree.add(5, 4);
        hashMap.put(6, 5);
        binaryTree.add(6, 5);
        assertTrue(binTreeCheck(binaryTree));
        assertEquals(hashMap, binaryTreeToHashMap(binaryTree));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDE() {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        BinaryTree<Integer, String> binaryTree = new BinaryTree<Integer, String>();
        hashMap.put(4, "A");
        binaryTree.add(4, "A");
        hashMap.put(1, "B");
        binaryTree.add(1, "B");
        hashMap.put(3, "C");
        binaryTree.add(3, "C");
        hashMap.put(5, "D");
        binaryTree.add(5, "D");
        hashMap.put(6, "E");
        binaryTree.add(6, "E");
        assertTrue(binTreeCheck(binaryTree));
        assertEquals(hashMap, binaryTreeToHashMap(binaryTree));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEAdding3G() {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        BinaryTree<Integer, String> binaryTree = new BinaryTree<Integer, String>();
        hashMap.put(4, "A");
        binaryTree.add(4, "A");
        hashMap.put(1, "B");
        binaryTree.add(1, "B");
        hashMap.put(3, "C");
        binaryTree.add(3, "C");
        hashMap.put(5, "D");
        binaryTree.add(5, "D");
        hashMap.put(6, "E");
        binaryTree.add(6, "E");
        hashMap.put(3, "G");
        binaryTree.add(3, "G");
        assertTrue(binTreeCheck(binaryTree));
        assertEquals(hashMap, binaryTreeToHashMap(binaryTree));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEDelete3() {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        BinaryTree<Integer, String> binaryTree = new BinaryTree<Integer, String>();
        hashMap.put(4, "A");
        binaryTree.add(4, "A");
        hashMap.put(1, "B");
        binaryTree.add(1, "B");
        hashMap.put(3, "C");
        binaryTree.add(3, "C");
        hashMap.put(5, "D");
        binaryTree.add(5, "D");
        hashMap.put(6, "E");
        binaryTree.add(6, "E");
        hashMap.remove(3);
        binaryTree.delete(3);
        assertTrue(binTreeCheck(binaryTree));
        assertEquals(hashMap, binaryTreeToHashMap(binaryTree));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEGet3() {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<Integer, String>();
        binaryTree.add(4, "A");
        binaryTree.add(1, "B");
        binaryTree.add(3, "C");
        binaryTree.add(5, "D");
        binaryTree.add(6, "E");
        assertTrue(binTreeCheck(binaryTree));
        assertEquals("C", binaryTree.get(3));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEGet7() {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<Integer, String>();
        binaryTree.add(4, "A");
        binaryTree.add(1, "B");
        binaryTree.add(3, "C");
        binaryTree.add(5, "D");
        binaryTree.add(6, "E");
        assertTrue(binTreeCheck(binaryTree));
        assertNull(binaryTree.get(7));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEContainsKey6() {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<Integer, String>();
        binaryTree.add(4, "A");
        binaryTree.add(1, "B");
        binaryTree.add(3, "C");
        binaryTree.add(5, "D");
        binaryTree.add(6, "E");
        assertTrue(binTreeCheck(binaryTree));
        assertTrue(binaryTree.containsKey(6));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEContainsKey2() {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<Integer, String>();
        binaryTree.add(4, "A");
        binaryTree.add(1, "B");
        binaryTree.add(3, "C");
        binaryTree.add(5, "D");
        binaryTree.add(6, "E");
        assertTrue(binTreeCheck(binaryTree));
        assertFalse(binaryTree.containsKey(2));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEDeleteAllNodes() {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<Integer, String>();
        binaryTree.add(4, "A");
        binaryTree.add(1, "B");
        binaryTree.add(3, "C");
        binaryTree.add(5, "D");
        binaryTree.delete(1);
        binaryTree.delete(3);
        binaryTree.delete(4);
        binaryTree.delete(5);

        assertTrue(binTreeCheck(binaryTree));
        assertTrue(binaryTree.isEmpty());
    }
}