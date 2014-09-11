/*
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Ing. DOuglas Barrios
* Miembros:
* - Max de Leon 13012
* - Javier Bucaro 13033
* - Kuk Ho Chung 13279
*/

package main;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GNXN000000
 */
public class BinaryTreeTest {
    
    public BinaryTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of left method, of class BinaryTree.
     */
    @Test
    public void testLeft() {
        System.out.println("left");
        BinaryTree instance = new BinaryTree();
        BinaryTree expResult = null;
        BinaryTree result = instance.left();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of right method, of class BinaryTree.
     */
    @Test
    public void testRight() {
        System.out.println("right");
        BinaryTree instance = new BinaryTree();
        BinaryTree expResult = null;
        BinaryTree result = instance.right();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parent method, of class BinaryTree.
     */
    @Test
    public void testParent() {
        System.out.println("parent");
        BinaryTree instance = new BinaryTree();
        BinaryTree expResult = null;
        BinaryTree result = instance.parent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLeft method, of class BinaryTree.
     */
    @Test
    public void testSetLeft() {
        System.out.println("setLeft");
        BinaryTree instance = new BinaryTree();
        instance.setLeft(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRight method, of class BinaryTree.
     */
    @Test
    public void testSetRight() {
        System.out.println("setRight");
        BinaryTree instance = new BinaryTree();
        instance.setRight(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParent method, of class BinaryTree.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        BinaryTree instance = new BinaryTree();
        instance.setParent(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of value method, of class BinaryTree.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        BinaryTree instance = new BinaryTree();
        Object expResult = null;
        Object result = instance.value();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class BinaryTree.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        Object value = null;
        BinaryTree instance = new BinaryTree();
        instance.setValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class BinaryTree.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        BinaryTree instance = new BinaryTree();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
