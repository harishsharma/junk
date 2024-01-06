package junk;

/**
 * Created by harish.sharma on 10/9/16.
 */
public class A1 {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(6);
        print(MergeLists(head, head1));
    }

    static void print(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }


    static Node MergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        if (headA == null && headB == null) return null;
        if (headA == null) return headB;
        if (headB == null) return headA;

        Node result = new Node(-1);
        Node res = result;
        while (headA != null && headB != null) {
            if (headA.data <= headB.data) {
                Node t = headA;
                headA = headA.next;
                res.next = t;
                t.next = null;
            } else {
                Node t = headB;
                headB = headB.next;
                res.next = t;
                t.next = null;
            }
            res = res.next;
        }
        if (headA != null) {
            res.next = headA;
        }
        if (headB != null) {
            res.next = headB;
        }
        return result.next;
    }

    static int GetNode(Node head, int n) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        int i = count - n;
        temp = head;
        while (--i > 0) {
            temp = temp.next;
        }
        return temp.data;

    }

    static Node Reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node first = null;
        Node temp = head;
        Node next = temp.next;
        while (next != null) {
            head.next = first;
            first = head;
            head = next;
            next = next.next;
        }
        head.next = first;
        return head;
    }


    static class Node {
        int data;
        Node next;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}

