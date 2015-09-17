package sedwick;

/**
 * 
 * @author harish.sharma
 *
 */
public class UnionFindNieve {

    private final int[] elements;
    private final int   size;

    public UnionFindNieve(int n) {
        this.elements = new int[n];
        this.size = n;
        for (int i = 0; i < n; i++)
            this.elements[i] = i;
    }

    public void union(int a, int b) {
        if (elements[a] == elements[b]) return;
        int x = elements[a];
        for (int i = 0; i < size; i++) {
            if (elements[i] == x) elements[i] = elements[b];
        }
    }

    public boolean isConnected(int a, int b) {
        return elements[a] == elements[b];
    }

    public static void main(String[] args) {
        UnionFindNieve un = new UnionFindNieve(5);
        un.union(0, 1);
        un.union(2, 3);
        un.union(1, 2);
        System.out.println(un.isConnected(0, 2));
        System.out.println(un.isConnected(1, 4));
    }
}
