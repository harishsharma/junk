package hackerrank;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import lombok.ToString;

/**
 * https://www.hackerrank.com/challenges/count-luck
 * 
 * @author harish.sharma
 *
 */
public class CountLuck {

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int rows = in.nextInt();
            int cols = in.nextInt();
            char[][] mat = new char[rows][cols];
            for (int j = 0; j < rows; j++) {
                mat[j] = in.next().toCharArray();
            }
            int k = in.nextInt();
            solve(mat, k);
        }
        in.close();
    }


    private static void solve1(char[][] mat, int k) {

    }

    private static void solve(char[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int count = 1;
        int source = 0;
        int des = 0;
        int[][] bac = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != 'X') {
                    if (mat[i][j] == 'M') source = count;
                    if (mat[i][j] == '*') des = count;
                    bac[i][j] = count++;
                }
            }
        }

        Graph g = new Graph(count);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != 'X') {
                    if (j - 1 >= 0 && mat[i][j - 1] != 'X') {
                        g.addEdge(bac[i][j], bac[i][j - 1]);
                    }
                    if (i + 1 < rows && mat[i + 1][j] != 'X') {
                        g.addEdge(bac[i][j], bac[i + 1][j]);
                    }
                    if (j + 1 < cols && mat[i][j + 1] != 'X') {
                        g.addEdge(bac[i][j], bac[i][j + 1]);
                    }
                    if (i - 1 >= 0 && mat[i - 1][j] != 'X') {
                        g.addEdge(bac[i][j], bac[i - 1][j]);
                    }
                }
            }
        }
        CC cc = new CC(g, source, des, k);

        System.out.println(cc.search(source, k, des, source, new boolean[g.vs]));
    }

    @ToString
    private static class Graph {
        int            vs;
        Set<Integer>[] adjList;

        @SuppressWarnings("unchecked")
        public Graph(int vs) {
            this.vs = vs;
            this.adjList = new HashSet[vs];
            for (int i = 0; i < vs; i++)
                adjList[i] = new HashSet<Integer>();
        }

        public void addEdge(int a, int b) {
            adjList[a].add(b);
            adjList[b].add(a);
        }
    }

    private static class CC {
        Graph     g;
        boolean[] marked;

        public CC(Graph g, int source, int des, int distance) {
            this.g = g;
            this.marked = new boolean[g.vs];
            preprocess(g, source);
        }

        private void preprocess(Graph g, int source) {
            marked[source] = true;
            for (int item : g.adjList[source]) {
                if (!marked[item]) {
                    preprocess(g, item);
                }
            }
        }

        public boolean search(int source, int k, int dest, int prev, boolean[] processed) {
            if (source == dest && k == 0) return true;
            if (k < 0) return false;
            Set<Integer> adj = g.adjList[source];
            if (adj.size() == 0) return false;
            processed[source] = true;
            if (adj.size() == 1) {
                int next = adj.iterator().next();
                if (!processed[next])
                    return search(next, k, dest, source, processed);
                else
                    return false;
            } else if (adj.size() == 2) {
                Iterator<Integer> itr = adj.iterator();
                int a = itr.next();
                int b = itr.next();
                if (adj.contains(prev)) {
                    int next = a == source ? b : a;
                    if (!processed[next]) return search(next, k, dest, source, processed);
                    return false;
                } else {
                    boolean res = false;
                    if (!processed[a]) res = search(a, k - 1, dest, source, processed);
                    if (!processed[b]) res = res || search(b, k - 1, dest, source, processed);
                    return res;
                }
            } else {
                boolean res = false;
                for (int i : adj) {
                    if (i != source) {
                        if (!processed[i]) res = res || search(i, k - 1, dest, source, processed);
                    }
                }
                return res;
            }
        }
    }

}
