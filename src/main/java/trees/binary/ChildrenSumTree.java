package trees.binary;

/**
 * Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
 * 
 * @author harish.sharma
 *
 */
public class ChildrenSumTree {

    public Node solve(Node root) {
        if (root == null || root.left == null && root.right == null) return root;

        Node left = solve(root.left);
        Node right = solve(root.right);

        int leftdata = left != null ? left.data : 0;
        int rightdata = right != null ? right.data : 0;
        root.data = leftdata + rightdata;
        return root;
    }

    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(8);
        root1.left.left = new Node(3);
        root1.left.right = new Node(5);
        root1.right = new Node(2);
        root1.right.left = new Node(3);
        // root1.right.right = new Node(1);

        System.out.println(new ChildrenSumTree().solve(root1));
    }
}
