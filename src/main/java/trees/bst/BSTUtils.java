package trees.bst;

import trees.Node;

public class BSTUtils {

    /**
     * Size of the tree whose root node is
     * 
     * @param node
     * @return
     */
    public static <T> int size(Node<? extends Comparable<T>> node) {
        if (node == null)
            return 0;
        else
            return node.getSize();
    }
}
