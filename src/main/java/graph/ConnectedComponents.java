package graph;

/**
 * 
 * @author harish.sharma
 *
 */
public class ConnectedComponents {

    private boolean[] connected;
    private int[]     id;
    private int       count;

    public ConnectedComponents(Graph g) {
        connected = new boolean[g.V()];
        id = new int[g.V()];
        preProcess(g);
    }

    private void preProcess(Graph g) {
        int v = g.V();
        for (int i = 0; i < v; i++) {
            if (!connected[i]) {
                // Can be improved.
                DFS dfs = new DFS(g, i);
                for (int j = 0; j < v; j++) {
                    if (dfs.isConnected(j)) {
                        connected[j] = true;
                        id[j] = count;
                    }
                }
                count++;
            }
        }
    }

    /**
     * are a and b connected.
     * 
     * @param a
     * @param b
     * @return
     */
    public boolean connected(int a, int b) {
        return id[a] == id[b];
    }

    /**
     * Number of connected components.
     */
    public int count() {
        return count;
    }

    /**
     * Identifier for CC (between 0 and count()-1) to which vertex v belongs.
     * 
     * @param v
     * @return
     */
    public int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);

        ConnectedComponents cc = new ConnectedComponents(g);
        System.out.println(cc.id(0));
        System.out.println(cc.id(1));
        System.out.println(cc.id(2));
        System.out.println(cc.id(3));
        System.out.println(cc.id(4));
        System.out.println(cc.id(5));
        System.out.println(cc.id(6));

        System.out.println(cc.connected(0, 1));
        System.out.println(cc.connected(0, 2));
        System.out.println(cc.connected(0, 3));
        System.out.println(cc.connected(0, 4));
        System.out.println(cc.connected(0, 5));
        System.out.println(cc.connected(1, 2));
        System.out.println(cc.connected(1, 1));
        System.out.println(cc.connected(1, 6));
        System.out.println(cc.connected(6, 1));
        System.out.println(cc.connected(3, 4));
        System.out.println(cc.connected(5, 6));

        System.out.println(cc.count());

    }
}
