package trees.binary;

import lombok.ToString;

/**
 * 
 * @author harish.sharma
 *
 */
@ToString
public class Node {
    int  data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
