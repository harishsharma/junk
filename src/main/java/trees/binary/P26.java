package trees.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Reverse Level Order Traversal
 * 
 * @author harish.sharma
 *
 */
public class P26 {

    public void solve(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int[] a = new int[10];
        int index = 0;
        while (!q.isEmpty()) {
            Node n = q.remove();
            a[index++] = n.data;
            if (n.right != null) q.add(n.right);
            if (n.left != null) q.add(n.left);
        }

        for (int i = index - 1; i >= 0; i--) {
            System.out.print(" " + a[i]);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(5);
        root.left.left = new Node(13);
        root.left.right = new Node(2);
        root.right = new Node(6);
        root.right.left = new Node(22);
        // root.right.right = new Node(3);

        new P26().solve(root);
    }
}
