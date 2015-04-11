package trees.binary;

/**
 * Given two binary trees, check if the first tree is subtree of the second one. A subtree of a tree T is a tree S
 * consisting of a node in T and all of its descendants in T. The subtree corresponding to the root node is the entire
 * tree; the subtree corresponding to any other node is called a proper subtree.
 * 
 * @author harish.sharma
 *
 */
public class P20 {

    public boolean solve(Node troot, Node sroot) {
        if (sroot == null && troot == null) return true;
        if (sroot == null || troot == null) return false;
        if (isIdentical(troot, sroot)) {
            return true;
        } else {
            return solve(troot.left, sroot) || solve(troot.right, sroot);
        }
    }

    private boolean isIdentical(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.data == b.data) {
            return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
        }
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

        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(2);

        Node root2 = new Node(5);
        root2.left = new Node(2);
        root2.right = new Node(3);

        Node root3 = new Node(5);
        root3.left = new Node(2);
        root3.right = new Node(2);

        System.out.println(new P20().solve(root, root1));
        System.out.println(new P20().solve(root, root2));
        System.out.println(new P20().solve(root, root3));
    }
}
