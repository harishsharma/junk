package linkedlist;

/**
 * Write a function that checks whether a given Linked List contains loop and if loop is present then removes the loop
 * and returns true. And if the list doesn’t contain loop then returns false.
 * 
 * @author harish.sharma
 *
 */
public class P9 {

    public boolean solve(Node a) {
        if (a == null) return false;
        Node slow = a;
        Node fast = a;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int len = 1;
                slow = slow.next;
                while (fast != slow) {
                    slow = slow.next;
                    len++;
                }
                Node first = a;
                Node second = a;
                for (int i = 0; i < len; i++) {
                    first = first.next;
                }
                while (first.next != second.next) {
                    first = first.next;
                    second = second.next;
                }
                first.next = null;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        a.next.next.next = new Node(4);
        a.next.next.next.next = new Node(5);
        a.next.next.next.next.next = new Node(6);
        a.next.next.next.next.next.next = a.next.next;

        System.out.println(new P9().solve(a));
    }
}
