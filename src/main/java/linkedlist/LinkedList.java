package linkedlist;

import com.google.common.base.Preconditions;

import lombok.Getter;

@Getter
public class LinkedList {
    private Node head;
    private int  size;

    public LinkedList(Node head) {
        Preconditions.checkNotNull(head);
        this.head = head;
        this.size = 0;
    }

    public LinkedList(int data) {
        this.head = new Node(data);
        this.size = 0;
    }

    public void addNodeBegin(Node node) {
        Preconditions.checkNotNull(node);
        node.next = head;
        head = node;
        size++;
    }

    public void addNodeBegin(int data) {
        Node a = new Node(data);
        addNodeBegin(a);
    }

    public void reverse() {
        if (head.next == null) return;
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

    public static void main(String[] args) {
        Node head = new Node(1);
        LinkedList list = new LinkedList(head);
        list.addNodeBegin(new Node(2));
        list.addNodeBegin(new Node(3));
        list.addNodeBegin(new Node(4));
        list.print();
        list.reverse();
        list.print();
    }
}
