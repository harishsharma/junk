package linkedlist;

import com.google.common.base.Preconditions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public LinkedList(Node head) {
        Preconditions.checkNotNull(head);
        this.head = head;
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        this.tail = tmp;
    }

    public LinkedList(int data) {
        this.head = new Node(data);
        this.tail = this.head;
    }

    /*
     * Add this node in the beginning of the current list. Node must be single non null node and
     *  if the node points to multiple nodes then all the rest nodes are dropped.
     */
    public void addNodeBegin(Node node) {
        Preconditions.checkNotNull(node);
        if (node.next != null) node.next = null;
        if (head == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void addNodeBegin(int data) {
        Node a = new Node(data);
        addNodeBegin(a);
    }


    public void addNodeLast(int data) {
        Node a = new Node(data);
        addNodeLast(a);
    }

    public void addNodeLast(Node node) {
        Preconditions.checkNotNull(node);
        if (node.next != null) node.next = null;
        if (head == null) {
            head = tail = node;
        }

        tail.next = node;
        tail = node;
    }

    public void reverse() {
        if (head == null || head.next == null) return;
        Node prev = null;
        Node current = head.next;

        while (current != null) {
            head.next = prev;
            prev = head;
            head = current;
            current = current.next;
        }
        head.next = prev;
    }

    public void print() {
        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + "->");
            pointer = pointer.next;
        }
        System.out.println();
    }


    public Node middle() {
        if (head == null) return null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public void append(LinkedList a) {
        tail.next = a.getHead();
        tail = a.getTail();
    }

    public int len() {
        int count = 0;
        Node h = head;
        while (h != null) {
            h = h.next;
            count++;
        }
        return count;
    }

    public static LinkedList merge(LinkedList a, LinkedList b) {

        Node aHead = a.head;
        Node bHead = b.head;
        Node p1 = aHead.next;
        Node p2 = bHead.next;
        aHead.next = bHead;
        while (p1 != null && p2 != null) {
            bHead.next = p1;
            bHead = bHead.next;
            p1 = p1.next;
            bHead.next = p2;
            bHead = bHead.next;
            p2 = p2.next;
        }
        if (p1 != null) {
            bHead.next = p1;
        } else {
            bHead.next = p2;
        }
        return new LinkedList(aHead);
    }

    public boolean hasCycle() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList a = new LinkedList(new Node(3));
        a.addNodeBegin(4);
        a.addNodeBegin(2);
        a.print();
        LinkedList b = new LinkedList(new Node(11));
        b.addNodeBegin(42);
        b.addNodeBegin(23);
        b.print();
        a.append(b);
        a.print();
        System.out.println(a.len());
    }

}
