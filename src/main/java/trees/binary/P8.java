package trees.binary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Write a function to print spiral order traversal of a tree.
 * 
 * @author harish.sharma
 *
 */
public class P8 {

    public void solve(Node root) {
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty() || !queue.isEmpty()) {
            while (!stack.isEmpty()) {
                Node a = stack.pop();
                System.out.print(" " + a.data);
                if (a.left != null) queue.add(a.left);
                if (a.right != null) queue.add(a.right);
            }
            while (!queue.isEmpty()) {
                Node b = queue.remove();
                System.out.print(" " + b.data);
                if (b.left != null) stack.add(b.left);
                if (b.right != null) stack.add(b.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.left.left = new Node(3);
        root1.left.right = new Node(4);
        root1.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        new P8().solve(root1);
    }
}
