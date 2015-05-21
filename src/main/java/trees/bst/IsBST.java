package trees.bst;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * @author harish.sharma
 *
 */
public class IsBST {

    public boolean solve(Node<Integer> root) {
        if (root == null || (root.left == null && root.right == null)) return true;

        int data = root.data;
        int leftData = root.left != null ? root.left.data : Integer.MIN_VALUE;
        int rightData = root.right != null ? root.right.data : Integer.MAX_VALUE;

        return data >= leftData && data < rightData && solve(root.left) && solve(root.right);

    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(1, null, null, 2);
        root.left = new Node<Integer>(0, null, null, 1);
        root.right = new Node<Integer>(3, null, null, 1);
        System.out.println(new IsBST().solve(root));

        Node<Integer> nRoot = new Node<Integer>(10, null, null, 1);
        BST<Integer> bst = new BST<Integer>(nRoot);
        bst.insert(12);
        bst.insert(1);
        bst.insert(354);
        bst.insert(12);
        bst.insert(1);
        bst.insert(3354);
        bst.insert(1212);
        bst.insert(1325);
        bst.insert(3354);
        System.out.println(new IsBST().solve(nRoot));
    }
}
