package trees.bst;

import com.google.common.base.Preconditions;

import trees.Node;

public class BST<T extends Comparable<T>> {

    private final Node<T> root;

    public BST(Node<T> root) {
        Preconditions.checkArgument(root != null, "Root element cannot be null");
        this.root = root;
        this.root.setSize(1);
    }

    public BST(T data) {
        this(new Node<T>(data, null, null, null));
    }

    /**
     * Inserts the incoming element into the BST.
     * 
     * @param ele
     */
    public void insert(T e) {

    }

    /**
     * 
     * @return size of the BST.
     */
    public int size() {
        return BSTUtils.size(root);
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
