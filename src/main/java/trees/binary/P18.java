package trees.binary;

/**
 * Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.
 * 
 * @author harish.sharma
 *
 */
public class P18 {

    public void solve(Node root, int k) {
        printAncestors(root, k);
    }

    private boolean printAncestors(Node root, int k) {
        if (root == null) return false;
        if (root.data == k) return true;
        if (printAncestors(root.left, k) || printAncestors(root.right, k)) {
            System.out.print(" " + root.data);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Node root1 = new Node(10);
        root1.left = new Node(8);
        root1.left.left = new Node(3);
        root1.left.right = new Node(5);
        root1.right = new Node(21);
        root1.right.left = new Node(3);
        root1.right.right = new Node(1);
        root1.right.right.right = new Node(1);
        root1.left.left.left = new Node(2);

        new P18().solve(root1, 21);
    }
}
