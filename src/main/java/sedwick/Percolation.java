package sedwick;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * 
 * @author harish.sharma
 *
 */
public class Percolation {

    private int[][]              percolate;
    private int                  size;
    private WeightedQuickUnionUF uf1;

    public Percolation(int n) {
        this.percolate = new int[n + 2][n + 2];
        this.uf1 = new WeightedQuickUnionUF((n + 1) * (n + 1) + 1);
        this.size = n;
    }

    private int indexOfTop() {
        return 0;
    }

    private int indexOfLast() {
        return (size + 1) * (size + 1);
    }

    private int indexIntoArray(int row, int col) {
        return row * (size + 1) + col;
    }

    public void open(int i, int j) {
        if (!isOpen(i, j)) {

        }
    }

    public boolean isOpen(int i, int j) {
        if (i < 1 || i > size || j < 1 || j > size) throw new IndexOutOfBoundsException("index out of bound");
        return percolate[i][j] != 0;
    }

    public boolean isFull(int i, int j) {
        if (i < 1 || i > size || j < 1 || j > size) throw new IndexOutOfBoundsException("index out of bound");
        return false;
        // Is this site connected to (0,0)
        // is site (row i, column j) full?
    }

    public boolean percolates() {
        return false;
    }

    public static void main(String[] args) {
        // test client (optional)
    }
}
