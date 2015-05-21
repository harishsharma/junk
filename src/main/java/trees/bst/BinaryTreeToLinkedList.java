package trees.bst;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * @author harish.sharma
 *
 */
public class BinaryTreeToLinkedList {

    public LinkedList<Integer> solve(Node<Integer> root) {
        if (root == null) return null;
        Stack<Node<Integer>> stack = new Stack<>();
        stack.add(root);
        LinkedList<Integer> result = new LinkedList<>();
        while (!stack.isEmpty()) {
            Node<Integer> node = stack.pop();
            result.add(node.data);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public Node<Integer> solve1(Node<Integer> root) {
        Node<Integer> p = root;
        Stack<Node<Integer>> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.isEmpty()) {
                p.right = stack.pop();
            }
            p = p.right;

        }
        return root;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(1, null, null, 0);
        root.left = new Node<Integer>(2, null, null, 0);
        root.left.left = new Node<Integer>(3, null, null, 0);
        root.left.right = new Node<Integer>(4, null, null, 0);
        root.right = new Node<Integer>(6, null, null, 0);
        root.right.right = new Node<Integer>(7, null, null, 0);
        // System.out.println(new P2().solve(root));
        System.out.println(new BinaryTreeToLinkedList().solve1(root));
    }
}
