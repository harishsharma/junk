package trees.binary;


/**
 * Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.
 * 
 * @author harish.sharma
 *
 */
public class KdistanceFromRoot {

    public void solve(Node root, int k) {
        printAtK(root, k - 1);
    }

    private void printAtK(Node root, int k) {
        if (root == null) return;
        if (k == 0) System.out.print(" " + root.data);
        printAtK(root.left, k - 1);
        printAtK(root.right, k - 1);
    }

    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(8);
        root1.left.left = new Node(3);
        root1.left.right = new Node(5);
        root1.right = new Node(2);
        root1.right.left = new Node(3);
        root1.right.right = new Node(1);
        root1.right.right.right = new Node(1);
        root1.left.left.left = new Node(2);

        new KdistanceFromRoot().solve(root1, 0);
        new KdistanceFromRoot().solve(root1, 1);
        new KdistanceFromRoot().solve(root1, 2);
        new KdistanceFromRoot().solve(root1, 3);
        new KdistanceFromRoot().solve(root1, 4);
    }
}
