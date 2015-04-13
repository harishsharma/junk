package graph;

/**
 * Is a given graph acyclic?
 * 
 * @author harish.sharma
 *
 */
public class P1 {

    // TODO:Incomplete
    private boolean hasCycle;
    private boolean marked[];

    public boolean solve(Graph g) {
        int v = g.V();
        marked = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!marked[i]) {
                dfs(g, i, i);
            }
        }
        return hasCycle;
    }

    private void dfs(Graph g, int a, int b) {
        marked[a] = true;
        for (Integer x : g.adj(a)) {
            if (!marked[x]) {
                dfs(g, x, a);
            }
        }
    }
}
