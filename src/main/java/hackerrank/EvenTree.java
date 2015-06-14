package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/even-tree
 * 
 * @author harish.sharma
 *
 */
public class EvenTree {

    private static class Graph {
        Set<Integer>[] adjList;
        int            v;

        @SuppressWarnings("unchecked")
        public Graph(int v) {
            this.v = v + 1;
            adjList = new HashSet[this.v];
            for (int i = 1; i < this.v; i++) {
                adjList[i] = new HashSet<>();
            }
        }

        public void addEdge(int a, int b) {
            adjList[a].add(b);
            adjList[b].add(a);
        }
    }

    private static class GraphProcess {
        Graph g;
        int[] sizes;

        public GraphProcess(Graph g) {
            this.g = g;
            this.sizes = new int[g.v];
            for (int i = 1; i < g.v; i++) {
                boolean[] processed = new boolean[g.v];
                process(g, i, processed);
            }
        }

        private int process(Graph g, int source, boolean[] processed) {
            if (sizes[source] == 0) {
                sizes[source] += 1;
                processed[source] = true;
                for (int i : g.adjList[source]) {
                    if (!processed[i]) {
                        if (sizes[i] != 0) {
                            sizes[source] += sizes[i];
                        } else {
                            sizes[source] += process(g, i, processed);
                        }
                    }
                }
            }
            return sizes[source];
        }

        public int solve() {
            int count = 0;
            for (int i = 1; i < g.v; i++) {
                if (sizes[i] % 2 == 0) count++;
            }
            return count - 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            g.addEdge(a, b);
        }
        GraphProcess gp = new GraphProcess(g);
        System.out.println(gp.solve());
        in.close();
    }
}
