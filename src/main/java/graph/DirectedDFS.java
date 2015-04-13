package graph;

/**
 * 
 * @author harish.sharma
 *
 */
public class DirectedDFS implements GraphSearch {

    private boolean[] marked;
    private int       count;

    public DirectedDFS(DiGraph g, int s) {
        marked = new boolean[g.V()];
        preProcess(g, s);
    }

    private void preProcess(DiGraph g, int v) {
        marked[v] = true;
        count++;
        for (int a : g.adj(v)) {
            if (!marked[a]) {
                preProcess(g, a);
            }
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
        DiGraph g = new DiGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        DirectedDFS s = new DirectedDFS(g, 0);
        System.out.println(s.isConnected(0));
        System.out.println(s.isConnected(1));
        System.out.println(s.isConnected(2));
        System.out.println(s.isConnected(3));
        System.out.println(s.isConnected(4));

        System.out.println(s.count());
    }
}
