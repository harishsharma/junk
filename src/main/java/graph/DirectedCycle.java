package graph;

import java.util.Stack;

/**
 * 
 * @author harish.sharma
 *
 */
public class DirectedCycle {

    // TODO: Incomplete
    private boolean   hasCycle;
    private boolean[] marked;

    public DirectedCycle(DiGraph g) {
        int v = g.V();
        marked = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!marked[i] && !hasCycle) {
                dfs(g, i);
            }
        }
    }

    private void dfs(DiGraph g, int i) {
        marked[i] = true;
        Stack<Integer> stack = new Stack<>();
        stack.add(i);
        while (!stack.isEmpty()) {
            int a = stack.pop();
            for (int x : g.adj(a)) {
                if (!marked[x]) {
                    marked[x] = true;
                    if (stack.contains(x)) {
                        hasCycle = true;
                        return;
                    }
                }
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public Iterable<Integer> cycle() {
        return null;
    }

    public static void main(String[] args) {

        DiGraph g = new DiGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);

        System.out.println(new DirectedCycle(g).hasCycle());
    }
}
