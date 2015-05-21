package trees.binary;

/**
 * Find the Maximum Depth or Height of a Tree
 * 
 * @author harish.sharma
 *
 */
public class HeightOfTree {
    public int solve(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.max(solve(root.left), solve(root.right));
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.right = new Node(4);
        root1.right.right = new Node(5);
        root1.left.right.left = new Node(4);

        System.out.println(new HeightOfTree().solve(root1));
    }
}
