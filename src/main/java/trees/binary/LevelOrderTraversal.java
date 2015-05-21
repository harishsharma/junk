package trees.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Level Order Tree Traversal
 * 
 * @author harish.sharma
 *
 */
public class LevelOrderTraversal {
    public void solve(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            System.out.print(" " + cur.data);
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(4);
        root1.left = new Node(2);
        root1.left.right = new Node(3);
        root1.left.left = new Node(1);
        root1.right = new Node(5);

        new LevelOrderTraversal().solve(root1);
    }
}
