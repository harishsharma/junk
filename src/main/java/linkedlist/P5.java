package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * @author harish.sharma
 *
 */
public class P5 {

    public LinkedList solve(LinkedList... linkedLists) {
        LinkedList[] input = linkedLists;
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                return o1.data - o2.data;
            }
        });
        int len = input.length;
        for (int i = 0; i < len; i++) {
            queue.add(input[i].getHead());
        }
        LinkedList result = new LinkedList();
        while (!queue.isEmpty()) {
            Node lowest = queue.remove();
            if (lowest.next != null) {
                queue.add(lowest.next);
            }
            result.addNodeLast(lowest.data);
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
        LinkedList c = new LinkedList();
        c.addNodeLast(-2);
        c.addNodeLast(2);
        c.addNodeLast(423);
        new P5().solve(a, b, c).print();
    }
}
