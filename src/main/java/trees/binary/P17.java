package trees.binary;

/**
 * Given a Binary Tree and a key, write a function that returns level of the key.
 * 
 * @author harish.sharma
 *
 */
public class P17 {

    public int solve(Node root, int key) {
        return returnLevel(root, key, 1);
    }

    private int returnLevel(Node root, int key, int level) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && root.data != key) {
            return 0;
        }
        if (root.data == key) return level;
        level++;
        int left = returnLevel(root.left, key, level);
        int right = returnLevel(root.right, key, level);
        if (left != 0)
            return left;
        else
            return right;
    }

    public static void main(String[] args) {

        Node root1 = new Node(10);
        root1.left = new Node(8);
        root1.left.left = new Node(3);
        root1.left.right = new Node(5);
        root1.right = new Node(21);
        root1.right.left = new Node(3);
        root1.right.right = new Node(1);
        root1.right.right.right = new Node(1);
        root1.left.left.left = new Node(2);

        System.out.println(new P17().solve(root1, 10));
        System.out.println(new P17().solve(root1, 8));
        System.out.println(new P17().solve(root1, 3));
        System.out.println(new P17().solve(root1, 5));
        System.out.println(new P17().solve(root1, 2));
        System.out.println(new P17().solve(root1, 211));
    }
}
