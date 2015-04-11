package trees.binary;

/**
 * Write a function that returns true if the given Binary Tree is SumTree else false. A SumTree is a Binary Tree where
 * the value of a node is equal to sum of the nodes present in its left subtree and right subtree. An empty tree is
 * SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree
 * 
 * @author harish.sharma
 *
 */
public class P19 {
    public boolean solve(Node root) {
        if (root == null || root.left == null && root.right == null) return true;
        boolean left = solve(root.left);
        boolean right = solve(root.right);
        int ld, rd;
        if (left && right) {
            if (root.left == null)
                ld = 0;
            else if (isLeaf(root.left)) {
                ld = root.left.data;
            } else {
                ld = 2 * root.left.data;
            }

            if (root.right == null)
                rd = 0;
            else if (isLeaf(root.right)) {
                rd = root.right.data;
            } else {
                rd = 2 * root.right.data;
            }

            return root.data == ld + rd;
        }
        return false;
    }

    private boolean isLeaf(Node node) {
        if (node == null) return false;
        if (node.left == null && node.right == null) return true;
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.right = new Node(5);
        root.right.left = new Node(2);
        root.right.right = new Node(3);

        System.out.println(new P19().solve(root));
    }
}
