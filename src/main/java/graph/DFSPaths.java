package graph;

import java.util.Stack;

/**
 * 
 * @author harish.sharma
 *
 */
public class DFSPaths implements Paths {

    private boolean[] marked;
    private int[]     edgeTo;
    private int       s;

    public DFSPaths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
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
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        DFSPaths paths = new DFSPaths(g, 0);
        System.out.println(paths.hasPathTo(0));
        System.out.println(paths.hasPathTo(1));
        System.out.println(paths.hasPathTo(2));
        System.out.println(paths.hasPathTo(3));
        System.out.println(paths.hasPathTo(4));

        System.out.println(paths.pathTo(0));
        System.out.println(paths.pathTo(1));
        System.out.println(paths.pathTo(2));
        System.out.println(paths.pathTo(3));
        System.out.println(paths.pathTo(4));
    }

}
