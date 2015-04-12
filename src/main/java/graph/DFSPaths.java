package graph;

import java.util.Stack;

public class DFSPaths implements Paths {

    private boolean[] marked;
    private int[]     edgeTo;
    private int       s;

    public DFSPaths(Graph g, int s) {
        this.s = s;
        preProcess(g, s);
    }

    private void preProcess(Graph g, int v) {
        marked[v] = true;
        for (int a : g.adj(v)) {
            if (!marked[a]) {
                edgeTo[a] = v;
                preProcess(g, a);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]) {
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 5);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(1, 2);
        g.addEdge(0, 1);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(0, 2);
    }

}
