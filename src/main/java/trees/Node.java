package trees;

import lombok.Data;

/**
 * Node or one entry inside a tree.
 * 
 * @author harish.sharma
 *
 * @param <T> data element in the tree. T should be comparable so that BST can use it to make decision about the
 *        branching.
 */
@Data
public class Node<T extends Comparable<T>> {
    private T       data;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;
    private int     size;

    public Node(T data, Node<T> left, Node<T> right, Node<T> parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        size = 0;
    }
}
