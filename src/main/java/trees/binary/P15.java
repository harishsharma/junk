package trees.binary;

/**
 * Given a binary tree, find out if the tree can be folded or not.
 * 
 * A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other. An empty
 * tree is considered as foldable.
 * 
 * @author harish.sharma
 *
 */
public class P15 {
    public boolean solve(Node root) {
        if (root == null) return true;
        return isFoldable(root.left, root.right);
    }

    private boolean isFoldable(Node left, Node right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return isFoldable(left.left, right.right) && isFoldable(left.right, right.left);
    }

    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(8);
        root1.left.left = new Node(3);
        root1.left.right = new Node(5);
        root1.right = new Node(2);
        root1.right.left = new Node(3);
        root1.right.right = new Node(1);
        root1.right.right.right = new Node(1);
        root1.left.left.left = new Node(2);

        System.out.println(new P15().solve(root1));
    }
}
