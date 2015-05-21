package trees.binary;

/**
 * Given a Binary Tree, check if all leaves are at same level or not.
 * 
 * @author harish.sharma
 *
 */
public class IsLeavesAtSameLevel {

    int     height;
    boolean isFirst = true;

    public boolean solve(Node root) {

        return check(root, 1);
    }

    private boolean check(Node root, int i) {
        if (root == null) return true;
        if (root.left == null && root.left == null) {
            if (isFirst) {
                height = i;
                isFirst = false;
            } else {
                if (i != height) return false;
            }
        }
        return check(root.left, i + 1) && check(root.right, i + 1);
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

        System.out.println(new IsLeavesAtSameLevel().solve(root));
    }
}
