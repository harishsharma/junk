package trees.binary;


/**
 * Diameter of a Binary Tree : The diameter of a tree (sometimes called the width) is the number of nodes on the longest
 * path between two leaves in the tree.
 * 
 * @author harish.sharma
 *
 */
public class P11 {

    int curMax = Integer.MIN_VALUE;

    public int solve(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (rightHeight + leftHeight + 1 > curMax) {
            curMax = rightHeight + leftHeight + 1;
        }
        solve(root.left);
        solve(root.right);
        return curMax;
    }

    private int height(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(8);
        root1.left.left = new Node(3);
        root1.left.right = new Node(5);
        root1.left.right.right = new Node(5);
        root1.right = new Node(2);
        root1.right.left = new Node(3);
        root1.right.right = new Node(-1);
        root1.right.right.right = new Node(-1);
        root1.right.right.right.right = new Node(-1);
        root1.right.right.right.right.right = new Node(-1);

        System.out.println(new P11().solve(root1));
    }
}
