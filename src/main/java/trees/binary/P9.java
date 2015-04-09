package trees.binary;

/**
 * Check for Children Sum Property in a Binary Tree.
 * 
 * @author harish.sharma
 *
 */
public class P9 {

    public boolean solve(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        int data = root.data;
        int leftData = root.left != null ? root.left.data : 0;
        int rightData = root.right != null ? root.right.data : 0;

        return data == leftData + rightData && solve(root.left) && solve(root.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(8);
        root1.left.left = new Node(3);
        root1.left.right = new Node(5);
        root1.right = new Node(2);
        root1.right.left = new Node(3);
        root1.right.right = new Node(-1);

        System.out.println(new P9().solve(root1));
    }
}
