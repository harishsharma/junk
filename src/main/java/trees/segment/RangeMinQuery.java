package trees.segment;

import java.util.Arrays;

/**
 * Range minimum query.
 * 
 * @author harish.sharma
 *
 */
public class RangeMinQuery {

    private int[]     in;
    private MinNode[] tree;

    public RangeMinQuery(int[] input) {
        in = Arrays.copyOf(input, input.length);
        int len = input.length;
        int size = Util.getSize(len);
        tree = new MinNode[size];
        for (int i = 0; i < size; i++)
            tree[i] = new MinNode();
        buildTree(1, 0, len - 1, in, tree);
    }

    private void buildTree(int node, int left, int right, int[] in, MinNode[] tree) {
        tree[node].start = left;
        tree[node].end = right;
        if (left == right) {
            tree[node].assignLeaf(in[left]);
        } else {
            buildTree(2 * node, left, (left + right) / 2, in, tree);
            buildTree(2 * node + 1, (left + right) / 2 + 1, right, in, tree);
            tree[node].merge(tree[2 * node], tree[2 * node + 1]);
        }
    }

    public int query(int i, int j) {
        return queryInternal(1, 0, in.length - 1, i, j, in, tree);
    }

    private int queryInternal(int node, int left, int right, int i, int j, int[] in, MinNode[] tree) {
        int a, b;
        if (left > j || right < i) return Integer.MAX_VALUE;
        if (left >= i && right <= j) return tree[node].getValue();
        a = queryInternal(2 * node, left, (left + right) / 2, i, j, in, tree);
        b = queryInternal(2 * node + 1, (left + right) / 2 + 1, right, i, j, in, tree);
        return Math.min(a, b);
    }

    public void modify(int pos, int val) {
        modifyInternal(1, pos, val, 0, in.length - 1, in, tree);
    }

    private void modifyInternal(int node, int pos, int val, int b, int e, int[] in, MinNode[] tree) {
        tree[node].min = Math.min(tree[node].min, val);
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

    private static class MinNode extends Node<Integer> {

        Integer min;

        @Override
        protected void assignLeaf(Integer a) {
            min = a;
        }

        @Override
        protected void merge(Node<Integer> left, Node<Integer> right) {
            MinNode l = (MinNode) left;
            MinNode r = (MinNode) right;
            min = Math.min(l.min, r.min);
        }

        @Override
        protected Integer getValue() {
            return min;
        }

    }

    public static void main(String[] args) {
        int[] a = { 3, 4, 5, 2, 8, 0, 1, 9};
        RangeMinQuery q = new RangeMinQuery(a);
        System.out.println(q.query(0, 0));
        System.out.println(q.query(0, 7));
        q.modify(0, -1);
        System.out.println(q.query(0, 0));
        System.out.println(q.query(0, 7));
    }
}
