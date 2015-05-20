package linkedlist;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * A: a1 -> a2 -> c1 -> c2 -> c3
 * <p>
 * B: b1 -> b2 -> b3 -> c1 -> c2 -> c3
 * <p>
 * begin to intersect at node c1.
 * 
 * @author harish.sharma
 *
 */
public class Intersection {
    public Node solve(LinkedList a, LinkedList b) {
        int aLen = a.len();
        int bLen = b.len();
        int diff = Math.abs(aLen - bLen);
        boolean isABigger = aLen > bLen ? true : false;
        Node aHead = a.getHead();
        Node bHead = b.getHead();
        if (isABigger) {
            moveByX(diff, aHead);
        } else {
            moveByX(diff, bHead);
        }
        while (aHead != null && bHead != null) {
            if (aHead == bHead) break;
            aHead = aHead.next;
            bHead = bHead.next;
        }
        return aHead;
    }

    private void moveByX(int x, Node a) {
        for (int i = 0; i < x; i++) {
            a = a.next;
        }
    }

    public static void main(String[] args) {
        LinkedList a = new LinkedList(1);
        a.addNodeLast(2);
        Node aa = new Node(3);
        Node bb = new Node(4);
        a.addNodeLast(aa);
        a.addNodeLast(bb);
        a.print();
        LinkedList b = new LinkedList(6);
        b.addNodeLast(7);
        b.addNodeLast(aa);
        b.addNodeLast(bb);
        b.print();
        System.out.println(new Intersection().solve(a, b));
    }
}
