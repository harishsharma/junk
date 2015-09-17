package sedwick;

/**
 * 
 * @author harish.sharma
 *
 */
public class UnionFindQuick {

    private final int[] ele;

    public UnionFindQuick(int n) {
        ele = new int[n];
        for (int i = 0; i < n; i++)
            ele[i] = i;
    }

    public void union(int a, int b) {
        int aR = root(a);
        int bR = root(b);
        if (aR == bR) return;
        ele[bR] = aR;
    }

    public boolean isConnected(int a, int b) {
        int aR = root(a);
        int bR = root(b);
        return aR == bR;
    }

    private int root(int a) {
        while (ele[a] != a)
            a = ele[a];
        return a;
    }

    public static void main(String[] args) {
        UnionFindQuick un = new UnionFindQuick(5);
        un.union(0, 1);
        un.union(2, 3);
        un.union(1, 2);
        System.out.println(un.isConnected(0, 2));
        System.out.println(un.isConnected(1, 4));
    }
}
