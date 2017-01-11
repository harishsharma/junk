package trees.bst;

import com.sun.org.apache.bcel.internal.generic.NEW;

import static com.sun.javafx.scene.traversal.Hueristic2D.findMin;

/**
 * Created by harish.sharma on 2/10/16.
 */
public class NewBST {

    private Node root;

    public NewBST() {
        this.root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.data < data)
            root.right = insert(root.right, data);
        else
            root.left = insert(root.left, data);
        return root;
    }

    public boolean searchBST(int data) {
        return searchBST(root, data);
    }

    private boolean searchBST(Node root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        if (root.data > data)
            return searchBST(root.left, data);
        else
            return searchBST(root.right, data);
    }

    public int findMin() {
        return findMin(root);
    }

    private int findMin(Node root) {
        if (root == null)
            return -1;
        while (root.left != null)
            root = root.left;
        return root.data;
    }

    public int findMax() {
        return findMax(root);
    }

    private int findMax(Node root) {
        if (root == null)
            return -1;
        while (root.right != null)
            root = root.right;
        return root.data;
    }

    public void printBST() {
        printBST(root);
    }

    private void printBST(Node root) {
        if (root == null)
            return;
        printBST(root.left);
        System.out.println(root.data);
        printBST(root.right);
    }

    public Node findSuccessor(int data) {
        if (root == null || root.data == data)
            throw new IllegalStateException("Empty tree");

        return null;
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static boolean areTreeIdentical(NewBST tree1, NewBST tree2) {
        return areTreeIdentical(tree1.root, tree2.root);
    }

    private static boolean areTreeIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return (root1.data == root2.data) && areTreeIdentical(root1.left, root2.left) && areTreeIdentical(root1.right,
                root2.right);
    }


    public static void main(String[] arg) {
        NewBST bst = new NewBST();
        bst.insert(1);
        bst.insert(0);
        bst.insert(4);
        NewBST bst1 = new NewBST();
        bst1.insert(1);
        bst1.insert(4);
        bst1.insert(0);
        System.out.println(NewBST.areTreeIdentical(bst,bst1));
    }

    public class Node {
        Integer data;
        Node    left;
        Node    right;

        public Node(Integer data) {
            this.data = data;
        }
    }
}
