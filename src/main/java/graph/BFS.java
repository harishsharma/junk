package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author harish.sharma
 *
 */
public class BFS implements GraphSearch {

    private boolean[] marked;
    private int       count;

    public BFS(Graph g, int s) {
        marked = new boolean[g.V()];
        preProcess(g, s);
    }

    private void preProcess(Graph g, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        marked[v] = true;
        count++;
        while (!q.isEmpty()) {
            Integer a = q.remove();
            for (Integer x : g.adj(a)) {
                if (!marked[x]) {
                    marked[x] = true;
                    count++;
                    q.add(x);
                }
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

        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        BFS bfs = new BFS(g, 0);
        System.out.println(bfs.isConnected(0));
        System.out.println(bfs.isConnected(1));
        System.out.println(bfs.isConnected(2));
        System.out.println(bfs.isConnected(3));
        System.out.println(bfs.isConnected(4));

        System.out.println(bfs.count());
    }
}
