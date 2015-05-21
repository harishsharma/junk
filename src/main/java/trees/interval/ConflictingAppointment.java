package trees.interval;

/**
 * Given n appointments, find all conflicting appointments.An appointment is conflicting, if it conflicts with any of
 * the previous appointments in array.
 * 
 * @author harish.sharma
 *
 */
public class ConflictingAppointment {

    public Node insertIntervalNode(Node root, Interval i) {
        if (root == null) return new Node(i);

        if (i.start < root.i.start)
            root.left = insertIntervalNode(root.left, i);
        else
            root.right = insertIntervalNode(root.right, i);

        if (root.max < i.end) root.max = i.end;
        return root;
    }

    public boolean doOverlap(Interval a, Interval b) {
        if (a.start < b.end && b.start < a.end) return true;
        return false;
    }

    public Interval searchOverlap(Node root, Interval i) {
        if (root == null) return null;
        if (doOverlap(root.i, i)) return root.i;

        if (root.left != null && root.left.max >= i.start) return searchOverlap(root.left, i);
        return searchOverlap(root.right, i);
    }

    public void printConflictingInterval(Interval[] intervals) {
        int len = intervals.length;
        Node root = null;
        root = insertIntervalNode(root, intervals[0]);
        for (int i = 1; i < len; i++) {
            Interval overlapped = searchOverlap(root, intervals[i]);
            if (overlapped != null) System.out.println("Conflists " + intervals[i]);
            root = insertIntervalNode(root, intervals[i]);
        }
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[6];
        intervals[0] = new Interval(1, 5);
        intervals[1] = new Interval(3, 7);
        intervals[2] = new Interval(2, 6);
        intervals[3] = new Interval(10, 15);
        intervals[4] = new Interval(5, 6);
        intervals[5] = new Interval(4, 100);
        new ConflictingAppointment().printConflictingInterval(intervals);
    }
}
