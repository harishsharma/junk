package trees.binary;

/**
 * Find the maximum sum leaf to root path in a Binary Tree.
 * 
 * @author harish.sharma
 *
 */
public class MaxSumLeafPath {

    int[] a      = new int[10];
    int[] f      = new int[10];
    int   curMax = Integer.MIN_VALUE;

    public void solve(Node root) {
        printMax(root, 0, 0);
        int size = f.length;
        for (int i = 0; i < size; i++) {
            if (f[i] != -1)
                System.out.print(" " + f[i]);
            else
                break;
        }
    }

    private void printMax(Node root, int max, int size) {
        if (root == null) return;
        max = max + root.data;
        a[size++] = root.data;
        if (root.left == null && root.right == null) {
            if (max > curMax) {
                curMax = max;
                for (int i = 0; i < size; i++) {
                    f[i] = a[i];
                }
                for (int i = size; i < a.length; i++) {
                    f[i] = -1;
                }
            }
        }
        printMax(root.left, max, size);
        printMax(root.right, max, size);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(5);
        root.left.left = new Node(13);
        root.left.right = new Node(2);
        root.right = new Node(5);
        root.right.left = new Node(22);
        root.right.right = new Node(3);
        new MaxSumLeafPath().solve(root);
    }
}
