package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/connected-cell-in-a-grid
 * 
 * @author harish.sharma
 *
 */
public class CellsInAGrid {

    public static int solve(int[][] a, int m, int n) {
        int[][] bac = new int[m][n];
        int vertices = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) bac[i][j] = vertices++;
            }

        Graph g = new Graph(vertices);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != 0) {
                    if (i - 1 > 0 && j - 1 > 0 && a[i - 1][j - 1] != 0) {
                        g.addEdge(bac[i][j], bac[i - 1][j - 1]);
                    }
                    if (j - 1 > 0 && a[i][j - 1] != 0) {
                        g.addEdge(bac[i][j], bac[i][j - 1]);
                    }
                    if (i + 1 < m && j - 1 > 0 && a[i + 1][j - 1] != 0) {
                        g.addEdge(bac[i][j], bac[i + 1][j - 1]);
                    }
                    if (i + 1 < m && a[i + 1][j] != 0) {
                        g.addEdge(bac[i][j], bac[i + 1][j]);
                    }
                    if (i + 1 < m && j + 1 < n && a[i + 1][j + 1] != 0) {
                        g.addEdge(bac[i][j], bac[i + 1][j + 1]);
                    }
                    if (j + 1 < n && a[i][j + 1] != 0) {
                        g.addEdge(bac[i][j], bac[i][j + 1]);
                    }
                    if (i - 1 > 0 && j + 1 < n && a[i - 1][j + 1] != 0) {
                        g.addEdge(bac[i][j], bac[i - 1][j + 1]);
                    }
                    if (i - 1 > 0 && a[i - 1][j] != 0) {
                        g.addEdge(bac[i][j], bac[i - 1][j]);
                    }
                }
            }
        }
        return new ConnectedComponent(g).max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        System.out.println(solve(a, m, n));
        in.close();
    }

    private static class Graph {

        int            vertices;
        Set<Integer>[] adjList;

        @SuppressWarnings("unchecked")
        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjList = new HashSet[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new HashSet<Integer>();
            }
        }

        public void addEdge(int a, int b) {
            adjList[a].add(b);
            adjList[b].add(a);
        }
    }

    private static class ConnectedComponent {
        boolean[] processed;
        int[]     cc;
        int       max = Integer.MIN_VALUE;

        public ConnectedComponent(Graph g) {
            int vertices = g.vertices;
            processed = new boolean[vertices];
            cc = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                if (!processed[i]) {
                    int comps = preprocess(g, i, i, 0);
                    max = Math.max(max, comps);
                }
            }
        }

        private int preprocess(Graph g, int source, int component, int sum) {
            processed[source] = true;
            cc[source] = component;
            sum++;
            for (int other : g.adjList[source]) {
                if (!processed[other]) sum = preprocess(g, other, component, sum);
            }
            return sum;
        }
    }
}
