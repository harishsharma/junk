package skiena.graph;

/**
 * 
 * @author harish.sharma
 *
 */
public class Graph {

    private Node[]  edges;
    private int[]   degree;
    private int     nvertices;
    private int     nedges;
    private boolean isDirected;

    public Graph(int vertices, boolean isDirected) {
        this.isDirected = isDirected;
        this.nvertices = vertices;
        this.nedges = 0;
        edges = new Node[vertices + 1];
        degree = new int[vertices + 1];
    }

    public void addEdge(int x, int y) {
        addEdge(x, y, isDirected);
    }

    private void addEdge(int x, int y, boolean isDirected) {
        Node temp = new Node(y);
        temp.next = edges[x];
        edges[x] = temp;
        degree[x]++;
        if (!isDirected) {
            addEdge(y, x, true);
        } else {
            nedges++;
        }
    }

    public void printGraph() {
        for (int i = 1; i <= nvertices; i++) {
            Node t = edges[i];
            while (t != null) {
                System.out.printf(" %d", t.x);
                t = t.next;
            }
            System.out.println();
        }
        System.out.println("Edges " + nedges);
    }

    public static void main(String[] args) {
        Graph g = new Graph(5, false);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.printGraph();
    }

    public static class Node {
        int  x;
        int  weight;
        Node next;

        public Node(int x) {
            this.x = x;
        }

        public Node(int x, int weight) {
            this.x = x;
            this.weight = weight;
        }
    }
}
