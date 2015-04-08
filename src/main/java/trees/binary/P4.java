package trees.binary;

/**
 * Given a binary tree, print out all of its root-to-leaf paths one per line.
 * 
 * @author harish.sharma
 *
 */
public class P4 {

    public void solve(Node root) {
        int[] a = new int[20];
        print(root, a, 0);
    }

    private void print(Node root, int[] a, int size) {
        if (root == null) return;
        a[size] = root.data;
        size++;
        if (root.left == null && root.right == null) {
            for (int i = 0; i < size; i++) {
                System.out.print(" " + a[i]);
            }
            System.out.println();
        }
        print(root.left, a, size);
        print(root.right, a, size);
    }

    public static void main(String[] args) {

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.right = new Node(4);
        root1.right.right = new Node(5);
        root1.left.right.left = new Node(4);

        new P4().solve(root1);
    }
}
