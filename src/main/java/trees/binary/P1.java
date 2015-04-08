package trees.binary;

/**
 * Determine if Two Trees are Identical
 * 
 * @author harish.sharma
 *
 */
public class P1 {
    public boolean solve(Node root1, Node root2) {
        if (root1 == root2) return true;
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.data == root2.data && solve(root1.left, root2.left) && solve(root1.right, root2.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.right = new Node(4);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.right = new Node(4);

        System.out.println(new P1().solve(root1, root2));
    }
}
