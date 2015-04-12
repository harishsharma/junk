package graph;

/**
 * 
 * @author harish.sharma
 *
 */
public class DFS implements GraphSearch {

    private boolean[] marked;
    private int       count;

    public DFS(Graph g, int s) {
        marked = new boolean[g.V()];
        preProcess(g, s);
    }

    private void preProcess(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int a : g.adj(v)) {
            if (!marked[a]) preProcess(g, a);
        }
    }

    @Override
    public boolean isConnected(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        DFS dfs = new DFS(g, 0);
        System.out.println(dfs.isConnected(0));
        System.out.println(dfs.isConnected(1));
        System.out.println(dfs.isConnected(2));
        System.out.println(dfs.isConnected(3));

        System.out.println(dfs.count());
    }
}
