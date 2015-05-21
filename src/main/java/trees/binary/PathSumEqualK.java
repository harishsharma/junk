package trees.binary;

/**
 * Given a binary tree and a number, return true if the tree has a root-to-leaf path such that adding up all the values
 * along the path equals the given number. Return false if no such path can be found. *
 * 
 * @author harish.sharma
 *
 */
public class PathSumEqualK {

    public boolean solve(Node root, int k) {
        if (root == null) return false;
        if (root.left == null && root.right == null && k == root.data) return true;
        return solve(root.left, k - root.data) || solve(root.right, k - root.data);
    }

    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(8);
        root1.left.left = new Node(3);
        root1.left.right = new Node(5);
        root1.right = new Node(2);
        root1.right.left = new Node(3);
        root1.right.right = new Node(1);
        System.out.println(new PathSumEqualK().solve(root1, 23));
    }
}
