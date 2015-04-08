package trees.binary;

/**
 * Convert a Binary Tree into its Mirror Tree
 * 
 * @author harish.sharma
 *
 */
public class P3 {
    public Node solve(Node root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        root.left = solve(root.left);
        root.right = solve(root.right);
        return root;
    }

    public static void main(String[] args) {

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.right = new Node(4);
        root1.right.right = new Node(5);
        root1.left.right.left = new Node(4);

        System.out.println(new P3().solve(root1));
    }
}
