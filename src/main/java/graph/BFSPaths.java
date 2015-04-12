package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author harish.sharma
 *
 */
public class BFSPaths implements Paths {

    private int[]     edgeTo;
    private boolean[] marked;
    private int       s;

    public BFSPaths(Graph g, int s) {
        edgeTo = new int[g.V()];
        marked = new boolean[g.V()];
        this.s = s;
        preProcess(g, s);
    }

    private void preProcess(Graph g, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        marked[v] = true;
        while (!q.isEmpty()) {
            Integer a = q.remove();
            for (Integer x : g.adj(a)) {
                if (!marked[x]) {
                    edgeTo[x] = a;
                    marked[x] = true;
                    q.add(x);
                }
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
            stack.add(i);
        }
        stack.add(s);
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

        BFSPaths paths = new BFSPaths(g, 0);
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
