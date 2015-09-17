package sedwick;

/**
 * 
 * @author harish.sharma
 *
 */
public class UFQWeighted {
    private final int[] ele;
    private final int[] size;

    public UFQWeighted(int n) {
        ele = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            ele[i] = i;
            size[i] = 1;
        }
    }


    public void union(int a, int b) {
        int aR = root(a);
        int bR = root(b);
        if (aR == bR) return;
        if (size[aR] > size[bR]) {
            ele[bR] = aR;
            size[aR] += size[bR];
        } else {
            ele[aR] = bR;
            size[bR] += size[aR];
        }
    }

    public boolean isConnected(int a, int b) {
        return root(a) == root(b);
    }

    private int root(int a) {
        while (a != ele[a]) {
            // falttening one level
            ele[a] = ele[ele[a]];
            a = ele[a];
        }
        return a;
    }

    public static void main(String[] args) {
        UFQWeighted un = new UFQWeighted(5);
        un.union(0, 1);
        un.union(2, 3);
        un.union(1, 2);
        System.out.println(un.isConnected(0, 2));
        System.out.println(un.isConnected(1, 4));
    }
}
