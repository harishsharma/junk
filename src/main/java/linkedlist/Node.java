package linkedlist;

/**
 * 
 * @author harish.sharma
 *
 */
public class Node {
    /*
     * Data is package private so that the code does not look verbose ,  otherwise it should be private field with getter/setters.
     */
    int  data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
