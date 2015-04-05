package linkedlist;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * 
 * Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author harish.sharma
 *
 */
public class P6 {
    public LinkedList solve(LinkedList a) {
        if (a == null || a.getHead() == null || a.getHead().next == null) return a;
        Node aHead = a.getHead();
        Node prev = aHead;
        Node next = aHead.next;
        while (next != null) {
            int data = next.data;
            if (prev.data == data) {
                next = next.next;
                continue;
            }
            prev.next = next;
            prev = next;
            next = next.next;
        }
        a.setTail(prev);
        prev.next = null;
        return a;
    }

    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.addNodeLast(1);
        a.addNodeLast(55);
        a.addNodeLast(23);
        a.addNodeLast(33);
        a.addNodeLast(34);
        a.addNodeLast(55);
        a.addNodeLast(53);
        a.addNodeLast(56);
        new P6().solve(a).print();
    }
}
