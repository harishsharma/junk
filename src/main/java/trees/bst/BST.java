package trees.bst;

import com.google.common.base.Preconditions;

public class BST<T extends Comparable<T>> {

    private Node<T> root;

    BST(Node<T> root) {
        Preconditions.checkArgument(root.data != null, "data cannot be null");
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
}
