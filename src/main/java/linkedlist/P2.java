package linkedlist;

/**
 * Given a singly linked list L: L0→L1→ ... →Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→...
 * 
 * @author harish.sharma
 *
 */
public class P2 {
    public LinkedList solve(LinkedList a) {
        Node middle = a.middle();
        Node tmp = middle.next;
        middle.next = null;
        LinkedList one = new LinkedList(a.getHead());
        LinkedList two = new LinkedList(tmp);
        two.reverse();
        return LinkedList.merge(one, two);
    }

    public static void main(String[] args) {
        LinkedList b = new LinkedList(4);
        b.addNodeBegin(6);
        b.addNodeBegin(5);
        b.addNodeBegin(9);
        b.addNodeBegin(91);
        b.print();
        new P2().solve(b).print();
    }
}
