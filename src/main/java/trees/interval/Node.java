package trees.interval;

import lombok.ToString;

/**
 * Interval tree Node.
 * 
 * @author harish.sharma
 *
 */
@ToString
public class Node {
    Interval i;
    int      max;
    Node     left;
    Node     right;

    public Node(Interval i) {
        this.i = i;
        this.max = i.end;
        this.left = null;
        this.right = null;
    }
}
