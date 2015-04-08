package trees.binary;

/**
 * Write a recursive function treeToList(Node root) that takes an ordered binary tree and rearranges the internal
 * pointers to make a circular doubly linked list out of the tree nodes.
 * 
 * @author harish.sharma
 *
 */
public class P5 {

    public Node solve(Node root) {
        if (root == null) return null;

        Node left = solve(root.left);
        Node right = solve(root.right);

        root.left = root;
        root.right = root;
        left = append(left, root);
        left = append(left, right);

        return left;
    }

    private Node append(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node aLast = a.left;
        Node bLast = b.left;
        aLast.right = b;
        b.left = aLast;
        a.left = bLast;
        b.right = a;

        return a;
    }

    public static void main(String[] args) {
        Node root1 = new Node(4);
        root1.left = new Node(2);
        root1.left.right = new Node(3);
        root1.left.left = new Node(1);
        root1.right = new Node(5);
        new P5().solve(root1);
    }
}
