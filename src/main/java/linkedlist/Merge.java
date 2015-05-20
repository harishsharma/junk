package linkedlist;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * of the first two lists.
 * 
 * @author harish.sharma
 *
 */
public class Merge {
    public LinkedList solve(LinkedList a, LinkedList b) {
        LinkedList result = new LinkedList();
        Node aHead = a.getHead();
        Node bHead = b.getHead();
        while (aHead != null && bHead != null) {
            if (aHead.data < bHead.data) {
                result.addNodeLast(aHead.data);
                aHead = aHead.next;
            } else {
                result.addNodeLast(bHead.data);
                bHead = bHead.next;
            }
        }

        while (aHead != null) {
            result.addNodeLast(aHead.data);
            aHead = aHead.next;
        }
        while (bHead != null) {
            result.addNodeLast(bHead.data);
            bHead = bHead.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.addNodeLast(1);
        a.addNodeLast(3);
        a.addNodeLast(5);
        a.addNodeLast(7);
        LinkedList b = new LinkedList();
        b.addNodeLast(0);
        b.addNodeLast(4);
        b.addNodeLast(6);
        new Merge().solve(a, b).print();
    }
}
