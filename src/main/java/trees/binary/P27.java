package trees.binary;

/**
 * Find depth of the deepest odd level leaf node.
 * 
 * @author harish.sharma
 *
 */
public class P27 {
    int curMax = Integer.MIN_VALUE;

    public int solve(Node root) {
        deep(root, 1);
        return curMax;
    }

    private void deep(Node root, int i) {
        if (root == null) return;
        if (isLead(root) && isOdd(i)) {
            if (i > curMax) curMax = i;
        }
        deep(root.left, i + 1);
        deep(root.right, i + 1);
    }

    private boolean isLead(Node a) {
        if (a == null) return false;
        if (a.left == null && a.right == null) return true;
        return false;
    }

    private boolean isOdd(int a) {
        return a % 2 == 1;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(5);
        root.left.left = new Node(13);
        root.left.right = new Node(2);
        root.right = new Node(6);
        root.right.left = new Node(22);
        root.right.right = new Node(3);
        root.right.right.right = new Node(3);

        System.out.println(new P27().solve(root));
    }
}
