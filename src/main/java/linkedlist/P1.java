package linkedlist;


/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each
 * of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author harish.sharma
 *
 */
public class P1 {

    public LinkedList solve(LinkedList a, LinkedList b) {
        a.reverse();
        b.reverse();
        Node aHead = a.getHead();
        Node bHead = b.getHead();
        int carry = 0;
        LinkedList result = null;
        while (aHead != null && bHead != null) {
            int sum = aHead.data + bHead.data;
            int finSum = carry + sum % 10;
            carry = sum / 10;
            if (result == null) {
                result = new LinkedList(finSum);
            } else {
                result.addNodeBegin(finSum);
            }
            aHead = aHead.next;
            bHead = bHead.next;
        }
        while (aHead != null) {
            int sum = aHead.data;
            int finSum = carry + sum % 10;
            carry = sum / 10;
            result.addNodeBegin(finSum);
            aHead = aHead.next;
        }

        while (bHead != null) {
            int sum = bHead.data;
            int finSum = carry + sum % 10;
            carry = sum / 10;
            result.addNodeBegin(finSum);
            bHead = bHead.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList a = new LinkedList(3);
        a.addNodeBegin(4);
        a.addNodeBegin(2);
        a.print();
        LinkedList b = new LinkedList(4);
        b.addNodeBegin(6);
        b.addNodeBegin(5);
        b.addNodeBegin(9);
        b.print();
        new P1().solve(a, b).print();
    }
}
