package trees.bst;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along
 * the path equals the given sum.
 * 
 * @author harish.sharma
 *
 */
public class SumInAPath {

    public boolean solve(Node<Integer> root, int k) {
        if (root == null) return false;
        if (root.data - k == 0 && root.left == null && root.right == null) return true;
        return solve(root.left, k - root.data) || solve(root.right, k - root.data);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(1, null, null, 0);
        root.left = new Node<Integer>(2, null, null, 0);
        root.left.left = new Node<Integer>(3, null, null, 0);
        root.left.right = new Node<Integer>(4, null, null, 0);
        root.right = new Node<Integer>(6, null, null, 0);
        root.right.right = new Node<Integer>(7, null, null, 0);
        root.right.left = new Node<Integer>(5, null, null, 0);
        System.out.println(new SumInAPath().solve(root, 12));
    }
}
