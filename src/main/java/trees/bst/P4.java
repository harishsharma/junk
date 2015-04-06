package trees.bst;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author harish.sharma
 *
 */
public class P4 {

    Node<Integer> solve(int[] a) {
        if (a.length == 0) return null;

        int end = a.length - 1;
        Node<Integer> root = solve(a, 0, end);
        return root;
    }

    private Node<Integer> solve(int[] a, int start, int end) {
        Node<Integer> root = null;
        if (start <= end) {
            int mid = start + (end - start) / 2;
            root = new Node<Integer>(a[mid], null, null, 0);
            root.left = solve(a, start, mid - 1);
            root.right = solve(a, mid + 1, end);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5};
        System.out.println(new P4().solve(a));
    }
}
