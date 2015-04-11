package trees.binary;

import lombok.ToString;

/**
 * Given a Binary Tree where each node has following structure, write a function to populate next pointer for all nodes.
 * The next pointer for every node should be set to point to inorder successor.
 * 
 * @author harish.sharma
 *
 */
public class P22 {

    // TODO:
    @ToString
    public static class SNode {
        int   data;
        SNode left;
        SNode right;
        SNode succ;

        public SNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.succ = null;
        }
    }
}
