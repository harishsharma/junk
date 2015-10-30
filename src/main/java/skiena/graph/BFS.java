package skiena.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import skiena.graph.Graph.Node;

public class BFS extends ProcessGraph {

    private final boolean[] isDiscovered;
    private final boolean[] isProcessed;
    private final int[]     parent;

    public BFS(Graph g, int source) {
        this.isDiscovered = new boolean[g.getNumberOfVertices()];
        this.isProcessed = new boolean[g.getNumberOfVertices()];
        this.parent = new int[g.getNumberOfVertices()];
        Arrays.fill(parent, -1);
        bsf(g, source);
    }


    private void bsf(Graph g, int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        isDiscovered[source] = true;
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            isProcessed[cur] = true;
            Node adjOfX = g.adjOfVertex(cur);
            while (adjOfX != null) {
                Node child = adjOfX;

                if (!isProcessed[child.x] || g.isDirected()) {
                    processEdge(cur, child.x);
                }

                if (!isDiscovered[child.x]) {
                    queue.add(child.x);
                    isDiscovered[child.x] = true;
                    parent[child.x] = cur;
                }
                adjOfX = adjOfX.next;
            }
        }
    }

    public void findPaths(int start, int end) {
        if (start == end || end == -1)
            System.out.print(start);
        else {
            findPaths(start, parent[end]);
            System.out.print(" " + end);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4, false);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(0, 1);
        g.addEdge(2, 3);
        BFS bfs = new BFS(g, 0);
        System.out.println(bfs.isProcessed[3]);
        bfs.findPaths(0, 3);
    }

}
