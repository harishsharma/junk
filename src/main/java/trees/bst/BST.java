package trees.bst;

import com.google.common.base.Preconditions;

/**
 * 
 * @author harish.sharma
 *
 * @param <T>
 */
public class BST<T extends Comparable<T>> {

    private Node<T> root;

    BST(Node<T> root) {
        Preconditions.checkArgument(root != null && root.data != null, "root or data cannot be null");
        this.root = root;
    }

    public BST(T data) {
        this(new Node<>(data, null, null, 1));
    }

    /**
     * Inserts the incoming element into the BST.
     * <p>
     * Null elements are not allowed and repeated elements are only inserted once.
     * 
     * 
     * @param e element to insert.
     */
    public void insert(T e) {
        if (e == null) return;
        root = insert(root, e);
    }

    private Node<T> insert(Node<T> node, T e) {
        if (node == null) return new Node<>(e, null, null, 1);

        int comp = e.compareTo(node.data);
        if (comp < 0) {
            node.left = insert(node.left, e);
        } else if (comp > 0) {
            node.right = insert(node.right, e);
        } else {
            node.data = e;
        }
        node.size = 1 + Node.size(node.left) + Node.size(node.right);
        return node;
    }

    /**
     * @param e
     * @return true if the element is present in the BST else false.
     */
    public boolean search(T e) {
        if (e == null) return false;
        return search(root, e);
    }

    private boolean search(Node<T> node, T e) {
        if (node == null) return false;
        int cmp = e.compareTo(node.data);
        if (cmp < 0)
            return search(root.left, e);
        else if (cmp > 0)
            return search(root.right, e);
        else
            return true;
    }

    /**
     * 
     * @return minimum element in the BST.
     */
    public T min() {
        Node<T> minNode = min(root);
        if (minNode != null) return minNode.data;
        return null;
    }

    private Node<T> min(Node<T> node) {
        if (node == null) return null;
        if (node.left == null)
            return node;
        else
            return min(node.left);
    }

    /**
     * 
     * @return maximum element in the BST.
     */
    public T max() {
        Node<T> maxNode = max(root);
        if (maxNode != null) return maxNode.data;
        return null;
    }

    private Node<T> max(Node<T> node) {
        if (node == null) return null;
        if (node.right == null)
            return node;
        else
            return max(node.right);
    }

    /**
     * Delete the min element in the BST.
     */
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node<T> deleteMin(Node<T> node) {
        if (node == null) return null;
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = Node.size(node.left) + Node.size(node.right) + 1;
        return node;
    }

    /**
     * Delete the max element in the BST.
     */
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node<T> deleteMax(Node<T> node) {
        if (node == null) return null;
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        node.size = Node.size(node.left) + Node.size(node.right) + 1;
        return node;
    }

    public void delete(T e) {
        root = delete(root, e);
    }

    private Node<T> delete(Node<T> node, T e) {
        if (node == null) return null;
        int comp = e.compareTo(node.data);
        if (comp < 0)
            node.left = delete(node.left, e);
        else if (comp > 0)
            node.right = delete(node.right, e);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null) return node.left;
            Node<T> temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = Node.size(node.left) + Node.size(node.right) + 1;
        return node;
    }

    /**
     * 
     * @return size of the BST.
     */
    public int size() {
        return Node.size(root);
    }

    /**
     * 
     * @return true when BST has no nodes else returns false.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return subtreeToString(root);
    }

    private String subtreeToString(Node<T> r) {
        String str = "";
        if (r == null) {
            return str;
        }
        str += r.data;
        str += " (" + subtreeToString(r.left) + ") (" + subtreeToString(r.right) + ")";
        return str;
    }

    public void printPreOrderTree() {
        printPreOrderTree(root);
        System.out.println();
    }

    private void printPreOrderTree(Node<T> root) {
        if (root == null) return;

        System.out.print(" " + root.data + " ");
        printPreOrderTree(root.left);
        printPreOrderTree(root.right);
    }

    public void printPostOrderTree() {
        printPostOrderTree(root);
        System.out.println();
    }

    private void printPostOrderTree(Node<T> root) {
        if (root == null) return;

        printPostOrderTree(root.left);
        printPostOrderTree(root.right);
        System.out.print(" " + root.data + " ");
    }

    public void printInOrderTree() {
        printInOrderTree(root);
        System.out.println();
    }

    private void printInOrderTree(Node<T> root) {
        if (root == null) return;

        printInOrderTree(root.left);
        System.out.print(" " + root.data + " ");
        printInOrderTree(root.right);
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>(10);
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(11);
        bst.insert(13);
        bst.printPreOrderTree();
        bst.printPostOrderTree();
        bst.printInOrderTree();
    }
}
