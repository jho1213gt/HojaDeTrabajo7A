/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.Iterator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GNXN000000
 */
public class BinarySearchTreeTest {
    
    public BinarySearchTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isEmpty method, of class BinarySearchTree.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        BinarySearchTree instance = new BinarySearchTree();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class BinarySearchTree.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        BinarySearchTree instance = new BinarySearchTree();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class BinarySearchTree.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        BinarySearchTree instance = new BinarySearchTree();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class BinarySearchTree.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        BinarySearchTree instance = new BinarySearchTree();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class BinarySearchTree.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        BinarySearchTree instance = new BinarySearchTree();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of treeString method, of class BinarySearchTree.
     */
    @Test
    public void testTreeString() {
        System.out.println("treeString");
        BinarySearchTree instance = new BinarySearchTree();
        String expResult = "";
        String result = instance.treeString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of locate method, of class BinarySearchTree.
     */
    @Test
    public void testLocate() {
        System.out.println("locate");
        BinarySearchTree instance = new BinarySearchTree();
        BinaryTree expResult = null;
        BinaryTree result = instance.locate(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of predecessor method, of class BinarySearchTree.
     */
    @Test
    public void testPredecessor() {
        System.out.println("predecessor");
        BinarySearchTree instance = new BinarySearchTree();
        BinaryTree expResult = null;
        BinaryTree result = instance.predecessor(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of successor method, of class BinarySearchTree.
     */
    @Test
    public void testSuccessor() {
        System.out.println("successor");
        BinarySearchTree instance = new BinarySearchTree();
        BinaryTree expResult = null;
        BinaryTree result = instance.successor(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class BinarySearchTree.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object value = null;
        BinarySearchTree instance = new BinarySearchTree();
        instance.add(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class BinarySearchTree.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object value = null;
        BinarySearchTree instance = new BinarySearchTree();
        boolean expResult = false;
        boolean result = instance.contains(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class BinarySearchTree.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Object value = null;
        BinarySearchTree instance = new BinarySearchTree();
        Object expResult = null;
        Object result = instance.get(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class BinarySearchTree.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object value = null;
        BinarySearchTree instance = new BinarySearchTree();
        Object expResult = null;
        Object result = instance.remove(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTop method, of class BinarySearchTree.
     */
    @Test
    public void testRemoveTop() {
        System.out.println("removeTop");
        BinarySearchTree instance = new BinarySearchTree();
        BinaryTree expResult = null;
        BinaryTree result = instance.removeTop(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class BinarySearchTree.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        BinarySearchTree instance = new BinarySearchTree();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
