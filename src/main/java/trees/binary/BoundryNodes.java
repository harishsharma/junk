package trees.binary;

import java.util.List;
import java.util.Stack;

import com.google.common.collect.Lists;

/**
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
 * 
 * @author harish.sharma
 *
 */
public class BoundryNodes {


    public void solve(Node root) {
        if (root == null) return;
        Node t = root;
        while (t != null && !isLeaf(t)) {
            System.out.print(" " + t.data);
            t = t.left;
        }
        List<Integer> nodes = Lists.newArrayList();
        addLeafNodes(root.left, nodes);
        addLeafNodes(root.right, nodes);
        for (Integer x : nodes) {
            System.out.print(" " + x);
        }
        Node s = root.right;
        Stack<Integer> stack = new Stack<>();
        while (s != null && !isLeaf(s)) {
            stack.add(s.data);
            s = s.right;
        }
        while (!stack.isEmpty())
            System.out.print(" " + stack.pop());
    }

    private void addLeafNodes(Node root, List<Integer> nodes) {
        if (root == null) return;
        if (root.left == null && root.right == null) nodes.add(root.data);
        addLeafNodes(root.left, nodes);
        addLeafNodes(root.right, nodes);
    }

    private boolean isLeaf(Node a) {
        if (a == null) return false;
        if (a.left == null && a.right == null) return true;
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(5);
        root.left.left = new Node(13);
        root.left.right = new Node(2);
        root.right = new Node(5);
        root.right.left = new Node(22);
        // root.right.right = new Node(3);

        new BoundryNodes().solve(root);
    }
}
