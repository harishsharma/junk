package trees.binary;

/**
 * Program to count leaf nodes in a binary tree.
 * 
 * @author harish.sharma
 *
 */
public class P7 {

    int count = 0;

    public int solve(Node root) {
        count(root);
        return count;
    }

    private void count(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            count++;
        }
        count(root.left);
        count(root.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(4);
        root1.left = new Node(2);
        root1.left.right = new Node(3);
        root1.left.left = new Node(1);
        root1.right = new Node(5);

        System.out.println(new P7().solve(root1));
    }
}
