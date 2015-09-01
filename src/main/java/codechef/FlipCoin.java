package codechef;

import java.util.Scanner;

/**
 * https://www.codechef.com/problems/FLIPCOIN
 * 
 * @author harish.sharma
 *
 */
class FlipCoin {

    // TAILS false HEAD true

    boolean[] in;
    int[]     tree;

    public FlipCoin(boolean[] in) {
        this.in = in;
        int size = (int) Math.pow(2, (31 - Integer.numberOfLeadingZeros(in.length)) + 1) * 2;
        tree = new int[size];
    }

    public int query(int i, int j) {
        return queryInternal(1, 0, in.length - 1, i, j, in, tree);
    }

    private int queryInternal(int node, int b, int e, int i, int j, boolean[] in, int[] tree) {
        if (i > e || j < b) return 0;
        if (b >= i && e <= j) return tree[node];
        int x = queryInternal(2 * node, b, (b + e) / 2, i, j, in, tree);
        int y = queryInternal(2 * node + 1, (b + e) / 2 + 1, e, i, j, in, tree);
        return x + y;
    }

    public void modify(int pos, boolean val) {
        modifyInternal(1, pos, val, 0, in.length - 1, in, tree);
    }

    public void modifyRange(int st, int end) {
        modifyInternalRange(1, st, end, 0, in.length - 1, in, tree);
    }

    private void modifyInternalRange(int node, int st, int end, int b, int e, boolean[] in, int[] tree) {
        if (b == e) {
            tree[node] += (in[st] == true) ? 1 : -1;
            in[st] = (in[st] == true) ? false : true;
            return;
        }
        int mid = (b + e) / 2;
        if (st > mid) {
            modifyInternalRange(2 * node + 1, st, end, mid + 1, e, in, tree);
        } else if (end <= mid) {
            modifyInternalRange(2 * mid, st, end, b, mid, in, tree);
        } else {
            modifyInternalRange(2 * node, st, mid, b, mid, in, tree);
            modifyInternalRange(2 * node + 1, mid + 1, end, mid + 1, e, in, tree);
        }
        tree[node] += tree[2 * node] + tree[2 * node + 1];
    }

    private void modifyInternal(int node, int pos, boolean val, int b, int e, boolean[] in, int[] tree) {
        tree[node] += (val == true) ? 1 : -1;
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

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        boolean[] arr = new boolean[n];
        FlipCoin coin = new FlipCoin(arr);
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int begin = in.nextInt();
            int end = in.nextInt();
            if (a == 1) {
                System.out.println(coin.query(begin, end));
            } else {
                coin.modifyRange(begin, end);
            }
        }
        in.close();
    }
}
