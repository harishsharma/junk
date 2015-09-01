package trees.segment;

import java.util.Arrays;

public class RangeSumQuery {

    int[] in;
    int[] tree;

    public RangeSumQuery(int[] in) {
        this.in = Arrays.copyOf(in, in.length);
        int size = (int) Math.pow(2, (31 - Integer.numberOfLeadingZeros(in.length) + 1)) * 2;
        tree = new int[size];
        build(1, 0, in.length - 1, in, tree);
    }

    private void build(int node, int b, int e, int[] in, int[] tree) {
        if (b == e) {
            tree[node] = in[b];
        } else {
            build(node * 2, b, (b + e) / 2, in, tree);
            build(node * 2 + 1, (b + e) / 2 + 1, e, in, tree);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    public int query(int i, int j) {
        return queryInternal(1, 0, in.length - 1, i, j, in, tree);
    }

    private int queryInternal(int node, int b, int e, int i, int j, int[] in, int[] tree) {
        if (i > e || j < b) return 0;
        if (b >= i && e <= j) return tree[node];
        int x = queryInternal(2 * node, b, (b + e) / 2, i, j, in, tree);
        int y = queryInternal(2 * node + 1, (b + e) / 2 + 1, e, i, j, in, tree);
        return x + y;
    }

    public void modify(int pos, int val) {
        modifyInternal(1, pos, val, 0, in.length - 1, in, tree);
    }

    private void modifyInternal(int node, int pos, int val, int b, int e, int[] in, int[] tree) {
        tree[node] += val - in[pos];
        if (b == e) {
            in[pos] = val;
        } else {
            int mid = (b + e) / 2;
            if (pos <= mid)
                modifyInternal(2 * node, pos, val, b, mid, in, tree);
            else
                modifyInternal(2 * node + 1, pos, val, mid + 1, e, in, tree);
        }
    }

    public static void main(String[] args) {
        int[] a = { 3, 4, 5, 2, 8, 0, 1, 9};
        RangeSumQuery q = new RangeSumQuery(a);
        System.out.println(q.query(0, 0));
        System.out.println(q.query(0, 7));
        System.out.println(q.query(1, 7));
        System.out.println(q.query(4, 7));
        q.modify(0, 12);
        System.out.println(q.query(0, 0));
        System.out.println(q.query(0, 7));
        System.out.println(q.query(1, 7));
        System.out.println(q.query(4, 7));
    }
}
