package trees.bst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {

    private BST<String> classUnderTest;
    Node<String>        root;

    @Before
    public void beforeTest() {
        root = new Node<String>("C", null, null, 1);
        classUnderTest = new BST<>(root);
    }

    @Test
    public void testInsert() {
        classUnderTest.insert("B");
        assertEquals(2, classUnderTest.size());
        classUnderTest.insert("A");
        assertEquals(3, classUnderTest.size());
    }

    @Test
    public void testSize() {
        assertEquals(1, classUnderTest.size());
    }

    @Test
    public void testSearch() {
        assertEquals(true, classUnderTest.search("C"));
        assertEquals(false, classUnderTest.search("B"));
        classUnderTest.insert("B");
        assertEquals(true, classUnderTest.search("B"));
    }

    @Test
    public void testToString() {
        assertEquals("C () ()", classUnderTest.toString());
    }

    @Test
    public void testMin() {
        assertEquals("C", classUnderTest.min());
        classUnderTest.insert("B");
        assertEquals("B", classUnderTest.min());
        classUnderTest.insert("D");
        assertEquals("B", classUnderTest.min());
        classUnderTest.insert("A");
        assertEquals("A", classUnderTest.min());
    }

    @Test
    public void testMax() {
        assertEquals("C", classUnderTest.max());
        classUnderTest.insert("B");
        assertEquals("C", classUnderTest.max());
        classUnderTest.insert("D");
        assertEquals("D", classUnderTest.max());
        classUnderTest.insert("A");
        assertEquals("D", classUnderTest.max());
    }

    @Test
    public void testMinDelete() {
        assertEquals(true, classUnderTest.search("C"));
        classUnderTest.deleteMin();
        assertEquals(false, classUnderTest.search("C"));
        classUnderTest.insert("C");
        assertEquals(true, classUnderTest.search("C"));
        classUnderTest.insert("B");
        assertEquals(true, classUnderTest.search("B"));
        classUnderTest.deleteMin();
        assertEquals(false, classUnderTest.search("B"));
        assertEquals(true, classUnderTest.search("C"));
    }


    @Test
    public void testMaxDelete() {
        assertEquals(true, classUnderTest.search("C"));
        classUnderTest.deleteMax();
        assertEquals(false, classUnderTest.search("C"));
        classUnderTest.insert("C");
        assertEquals(true, classUnderTest.search("C"));
        classUnderTest.insert("B");
        assertEquals(true, classUnderTest.search("B"));
        classUnderTest.deleteMax();
        assertEquals(true, classUnderTest.search("B"));
        assertEquals(false, classUnderTest.search("C"));
    }
}
