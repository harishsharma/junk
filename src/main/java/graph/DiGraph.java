package graph;

import java.util.LinkedList;

/**
 * 
 * @author harish.sharma
 *
 */
public class DiGraph {

    private final int             V;
    private int                   E;
    private LinkedList<Integer>[] adjList;

    @SuppressWarnings("unchecked")
    public DiGraph(int V) {
        this.V = V;
        this.adjList = (LinkedList<Integer>[]) new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int a, int b) {
        adjList[a].add(b);
        E++;
    }

    public Iterable<Integer> adj(int a) {
        return adjList[a];
    }

    /**
     * reverse of this {@link DiGraph}.
     * 
     * @return
     */
    DiGraph reverse() {
        DiGraph result = new DiGraph(V);
        for (int i = 0; i < V; i++) {
            for (Integer a : adj(i)) {
                result.addEdge(i, a);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }

}
