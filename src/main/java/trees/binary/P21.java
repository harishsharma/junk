package trees.binary;

import java.util.LinkedList;
import java.util.Queue;

import lombok.ToString;

/**
 * Write a function to connect all the adjacent nodes at the same level in a binary tree.
 * 
 * @author harish.sharma
 *
 */
public class P21 {

    public SNode solve(SNode root) {

        if (root == null) return null;
        Queue<SNode> queue1 = new LinkedList<>();
        Queue<SNode> queue2 = new LinkedList<>();
        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                SNode a = queue1.remove();
                SNode b = queue1.peek();
                a.nextRight = b;
                if (a.left != null) queue2.add(a.left);
                if (a.right != null) queue2.add(a.right);
            }

            while (!queue2.isEmpty()) {
                SNode a = queue2.remove();
                SNode b = queue2.peek();
                a.nextRight = b;
                if (a.left != null) queue1.add(a.left);
                if (a.right != null) queue1.add(a.right);
            }
        }
        return root;
    }

    @ToString
    public static class SNode {
        int   data;
        SNode left;
        SNode right;
        SNode nextRight;

        public SNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.nextRight = null;
        }
    }

    public static void main(String[] args) {
        SNode root = new SNode(1);
        root.left = new SNode(2);
        root.right = new SNode(3);
        root.left.left = new SNode(4);
        root.left.right = new SNode(5);
        System.out.println(new P21().solve(root));
    }
}
