package AlgoManual;

/**
 * Created by harish.sharma on 2/14/16.
 */
public class ReverseList {

    private Node head;

    public ReverseList() {
        head = null;
    }

    public void insert(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        Node headNode = head;
        while (headNode != null) {
            System.out.print(" " + headNode.data);
            headNode = headNode.next;
        }
    }

    public int middle() {
        if (head == null)
            return Integer.MIN_VALUE;
        if (head.next == null)
            return head.data;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public void reverse() {
        Node prev = null;
        Node first = head;
        Node second = first.next;
        if (second == null)
            return;
        while (second != null) {
            first.next = prev;
            prev = first;
            first = second;
            second = second.next;
        }
        first.next = prev;
        head = first;
    }

    private static class Node {
        private int  data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }


    public boolean isLoopPresent() {
        return isLoopPresent(head);
    }

    public boolean isLoopPresent(Node head) {
        if (head == null)
            return false;

        if (head.next == null)
            return false;

        Node fast = head.next, slow = head;
        while (fast != null && fast.next != null && slow != null) {
            if (fast == slow)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public Node shuffleList(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node middleHead = slow;
        Node temp1 = head;
        while (temp1.next.next != slow.next) {
            temp1 = temp1.next;
        }
        temp1.next = null;

        Node first = head;
        Node second = middleHead;
        Node savedNext = first.next;
        while (savedNext != null) {
            first.next = second;
            Node tempNext = second.next;
            second.next = savedNext;
            savedNext = tempNext;
            Node temp = first;
            first = second;
            second = first;
        }
        return head;
    }

    public void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] argv) {
        ReverseList list = new ReverseList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.print();
        System.out.println(list.isLoopPresent(list.head));
        Node head = new Node(1);
        Node first = new Node(2);
        Node second = new Node(3);
        Node third = new Node(4);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = second;

        System.out.println(list.isLoopPresent(head));
    }

}
