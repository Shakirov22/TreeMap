package edu.BinaryTree;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TreeMapTester {

    @Test
    public void testIntegerKeyIntegerValueWithKeys41356AndValues12345() {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        hashMap.put(4, 1);
        treeMap.put(4, 1);
        hashMap.put(1, 2);
        treeMap.put(1, 2);
        hashMap.put(3, 3);
        treeMap.put(3, 3);
        hashMap.put(5, 4);
        treeMap.put(5, 4);
        hashMap.put(6, 5);
        treeMap.put(6, 5);
        assertEquals(hashMap, (new BinaryTreeTester()).binaryTreeToHashMap(treeMap.binaryTree));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDE() {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        hashMap.put(4, "A");
        treeMap.put(4, "A");
        hashMap.put(1, "B");
        treeMap.put(1, "B");
        hashMap.put(3, "C");
        treeMap.put(3, "C");
        hashMap.put(5, "D");
        treeMap.put(5, "D");
        hashMap.put(6, "E");
        treeMap.put(6, "E");
        assertEquals(hashMap, (new BinaryTreeTester()).binaryTreeToHashMap(treeMap.binaryTree));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEAdding3G() {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        hashMap.put(4, "A");
        treeMap.put(4, "A");
        hashMap.put(1, "B");
        treeMap.put(1, "B");
        hashMap.put(3, "C");
        treeMap.put(3, "C");
        hashMap.put(5, "D");
        treeMap.put(5, "D");
        hashMap.put(6, "E");
        treeMap.put(6, "E");
        hashMap.put(3, "G");
        treeMap.put(3, "G");
        assertEquals(hashMap, (new BinaryTreeTester()).binaryTreeToHashMap(treeMap.binaryTree));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEDelete3() {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        hashMap.put(4, "A");
        treeMap.put(4, "A");
        hashMap.put(1, "B");
        treeMap.put(1, "B");
        hashMap.put(3, "C");
        treeMap.put(3, "C");
        hashMap.put(5, "D");
        treeMap.put(5, "D");
        hashMap.put(6, "E");
        treeMap.put(6, "E");
        hashMap.remove(3);
        treeMap.remove(3);
        assertEquals(hashMap, (new BinaryTreeTester()).binaryTreeToHashMap(treeMap.binaryTree));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEGet5() {
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        treeMap.put(4, "A");
        treeMap.put(1, "B");
        treeMap.put(3, "C");
        treeMap.put(5, "D");
        treeMap.put(6, "E");
        assertEquals("D", treeMap.get(5));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEGet8() {
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        treeMap.put(4, "A");
        treeMap.put(1, "B");
        treeMap.put(3, "C");
        treeMap.put(5, "D");
        treeMap.put(6, "E");
        assertNull(treeMap.get(8));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEContainsKey6() {
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        treeMap.put(4, "A");
        treeMap.put(1, "B");
        treeMap.put(3, "C");
        treeMap.put(5, "D");
        treeMap.put(6, "E");
        assertTrue(treeMap.containsKey(6));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEContainsKey2() {
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        treeMap.put(4, "A");
        treeMap.put(1, "B");
        treeMap.put(3, "C");
        treeMap.put(5, "D");
        treeMap.put(6, "E");
        assertFalse(treeMap.containsKey(2));
    }

    @Test
    public void testIntegerKeyStringValueWithKeys41356AndValuesABCDEDeleteAllNodes() {
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        treeMap.put(1, "B");
        treeMap.put(3, "C");
        treeMap.put(5, "D");
        treeMap.remove(1);
        treeMap.remove(3);
        treeMap.remove(4);
        treeMap.remove(5);

        assertTrue(treeMap.isEmpty());
    }
}
