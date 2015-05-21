package trees.binary;

/**
 * Given a binary tree, print all root-to-leaf paths
 * 
 * @author harish.sharma
 *
 */
public class PrintPathsToLeaf {

    int[] a = new int[20];

    public void solve(Node root) {
        print(root, 0);
    }

    private void print(Node root, int size) {
        if (root == null) return;
        a[size] = root.data;
        size++;
        if (root.left == null && root.right == null) {
            for (int i = 0; i < size; i++) {
                System.out.print(" " + a[i]);
            }
            System.out.println();
        }
        print(root.left, size);
        print(root.right, size);
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

        new PrintPathsToLeaf().solve(root1);
    }
}
