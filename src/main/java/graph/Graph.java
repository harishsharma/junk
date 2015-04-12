package graph;

import java.util.LinkedList;

/**
 * 
 * @author harish.sharma
 *
 */
public class Graph {

    private int                   V;
    private int                   E;
    private LinkedList<Integer>[] adjList;

    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adjList = (LinkedList<Integer>[]) new LinkedList[V];
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
        adjList[b].add(a);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adjList[v];
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

    public static int degree(Graph g, int v) {
        int count = 0;
        for (@SuppressWarnings("unused")
        Integer a : g.adj(v)) {
            count++;
        }
        return count;
    }

    public static int maxDegree(Graph g) {
        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i < g.V; i++) {
            int deg = degree(g, i);
            max = Math.max(deg, max);
        }
        return max;
    }

    public static int avgDegree(Graph g) {
        return 2 * g.E / g.E;
    }
}
