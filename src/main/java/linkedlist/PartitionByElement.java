package linkedlist;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
 * equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author harish.sharma
 *
 */
public class PartitionByElement {
    public LinkedList solve(LinkedList a, int k) {
        LinkedList small = new LinkedList();
        LinkedList big = new LinkedList();
        Node aHead = a.getHead();
        while (aHead != null) {
            if (aHead.data < k) {
                small.addNodeLast(aHead.data);
            } else {
                big.addNodeLast(aHead.data);
            }
            aHead = aHead.next;
        }
        small.append(big);
        return small;
    }

    public static void main(String[] args) {
        LinkedList a = new LinkedList(new Node(1));
        a.addNodeLast(4);
        a.addNodeLast(3);
        a.addNodeLast(2);
        a.addNodeLast(2);
        a.addNodeLast(5);
        a.print();
        new PartitionByElement().solve(a, 3).print();
    }
}
