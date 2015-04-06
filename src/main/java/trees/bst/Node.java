package trees.bst;

import lombok.AllArgsConstructor;
import lombok.ToString;


/**
 * Node or one entry inside a tree.
 * 
 * @author harish.sharma
 *
 * @param <T> data element in the tree. T should be comparable so that BST can use it to make decision about the
 *        branching.
 */
@ToString
@AllArgsConstructor
public class Node<T extends Comparable<T>> {
    T       data;
    Node<T> left;
    Node<T> right;
    int     size;

    /**
     * Size of the subtree(including this node).
     * 
     * @param node
     * @return
     */
    public static <T> int size(Node<? extends Comparable<T>> node) {
        if (node == null)
            return 0;
        else
            return node.size;
    }
}
