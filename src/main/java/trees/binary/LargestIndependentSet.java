package trees.binary;

/**
 * Given a Binary Tree, find size of the Largest Independent Set(LIS) in it. A subset of all tree nodes is an
 * independent set if there is no edge between any two nodes of the subset.
 * 
 * @author harish.sharma
 *
 */
public class LargestIndependentSet {

    public int solve(Node root) {
        if (root == null) return 0;

        int ls = solve(root.left);
        int rs = solve(root.right);

        int curSize = 1;

        if (root.left != null) curSize += solve(root.left.left) + solve(root.left.right);
        if (root.right != null) curSize += solve(root.right.left) + solve(root.right.right);

        return Math.max(curSize, ls + rs);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(5);
        root.left.left = new Node(13);
        root.left.right = new Node(2);
        root.right = new Node(5);
        root.right.left = new Node(22);
        // root.right.right = new Node(3);

        System.out.println(new LargestIndependentSet().solve(root));
    }
}
