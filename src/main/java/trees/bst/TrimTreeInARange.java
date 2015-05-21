package trees.bst;

/**
 * Given the root of a binary search tree and 2 numbers min and max, trim the tree such that all the numbers in the new
 * tree are between min and max (inclusive). The resulting tree should still be a valid binary search tree.
 * 
 * @author harish.sharma
 *
 */
public class TrimTreeInARange {

    public static Node<Integer> solve(Node<Integer> root, int min, int max) {
        if (root == null) return root;
        root.left = solve(root.left, min, max);
        root.right = solve(root.right, min, max);
        if (root.data >= min && root.data <= max)
            return root;
        else if (root.data < min)
            return root.right;
        else
            return root.left;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(8);
        root.left = new Node<Integer>(3);
        root.left.left = new Node<Integer>(1);
        root.left.right = new Node<Integer>(6);
        root.left.right.left = new Node<Integer>(4);
        root.left.right.right = new Node<Integer>(7);
        root.right = new Node<Integer>(10);
        root.right.right = new Node<Integer>(14);
        root.right.right.left = new Node<Integer>(13);

        System.out.println(solve(root, 5, 13));
    }
}
