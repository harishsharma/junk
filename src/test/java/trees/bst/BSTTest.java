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
        System.out.println(classUnderTest);
    }
}
