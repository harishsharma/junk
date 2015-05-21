package trees.binary;

/**
 * How to determine if a binary tree is height-balanced? An empty tree is height-balanced. A non-empty binary tree T is
 * balanced if: 1) Left subtree of T is balanced 2) Right subtree of T is balanced 3) The difference between heights of
 * left subtree and right subtree is not more than 1.
 * 
 * @author harish.sharma
 *
 */
public class IsHeightBalanced {

    public boolean solve(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        return solve(root.left) && solve(root.right) && Math.abs(lh - rh) <= 1;
    }

    private int height(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean solve1(Node root) {

        return isBalanced(root, new Wrapper<Integer>(0));
    }

    private boolean isBalanced(Node root, Wrapper<Integer> height) {
        Wrapper<Integer> lh = new Wrapper<>(0);
        Wrapper<Integer> rh = new Wrapper<>(0);
        boolean lb = false, rb = false;
        if (root == null) {
            height.setValue(0);
            return true;
        }
        lb = isBalanced(root.left, lh);
        rb = isBalanced(root.right, rh);

        height.setValue(1 + Math.max(lh.getValue(), rh.getValue()));
        return Math.abs(lh.getValue() - rh.getValue()) <= 1 && lb && rb;
    }

    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(8);
        root1.left.left = new Node(3);
        root1.left.right = new Node(5);
        root1.right = new Node(2);
        root1.right.left = new Node(3);
        root1.right.right = new Node(-1);
        root1.right.right.right = new Node(-1);
        // root1.right.right.right.right = new Node(-1);

        System.out.println(new IsHeightBalanced().solve1(root1));
    }
}
