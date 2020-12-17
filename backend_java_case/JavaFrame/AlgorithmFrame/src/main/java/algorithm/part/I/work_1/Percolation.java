package algorithm.part.I.work_1;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Programming Assignment 1: Percolation
 * @author 69410
 *
 */
public class Percolation {
    private final static int virtualTop = 0;
    private int n;          
    private int gridLength;
    private int virtualBottom;
    private boolean[] grid;
    private boolean isPercolated;
    private WeightedQuickUnionUF unionInstance;
    private WeightedQuickUnionUF backWash;
    // create n-by-n grid, with all sites blocked 
    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Illegal Argument"); 
        }       
        this.n = n;
        gridLength = n * n + 2;
        isPercolated = false;
        virtualBottom = n * n + 1;
        unionInstance = new WeightedQuickUnionUF(gridLength);
        backWash = new WeightedQuickUnionUF(gridLength - 1);
        grid = new boolean[gridLength];
    }
    
    // open site (row, col) if it is not open already   
    public void open(int row, int col) {
        isValidBounds(row, col);
        if (isOpen(row, col))
            return;
        int gridId = xyTo1D(row, col);
        grid[xyTo1D(row, col)] = true;
        if (1 == row) {
            unionInstance.union(virtualTop, gridId);
            backWash.union(virtualTop, gridId);
        }
        if (n == row) {
            unionInstance.union(virtualBottom, gridId);
        }
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        for (int i = 0; i < 4; i++) {
            int posX = row + dx[i];
            int posY = col + dy[i];
            if (isPosValid(posX, posY) 
                    && isOpen(posX, posY)) {
                int posId = xyTo1D(posX, posY);
                unionInstance.union(gridId, posId);
                backWash.union(gridId, posId);
            }   
        }


    }

    private int xyTo1D(int row, int col) {
        int i = (row - 1)  * n + col;
        return i;
    }

    private boolean isPosValid(int row, int col) {
        if (row >= 1 && row <= n && col >= 1 && col <= n) {
            return true;
        }
        return false;
    }

    private void isValidBounds(int row, int col) {
        if (row < 1 || row > n)
            throw new IndexOutOfBoundsException("Row index out of bounds");
        if (col < 1 || col > n)
            throw new IndexOutOfBoundsException("column index out of bounds");
    }   

    // is site (row, col) open?   
    public boolean isOpen(int row, int col) {
        isValidBounds(row, col);
        return (grid[xyTo1D(row, col)] == false ? false : true);
    }
    // is site (row, col) full?   
    public boolean isFull(int row, int col) {
        isValidBounds(row, col);
        return backWash.connected(virtualTop, xyTo1D(row, col));
    }
    // number of open sites   
    public int numberOfOpenSites() {
        int openNum = 0;
        for (int i = 1; i < virtualBottom; i++) {
            if (grid[i])
                openNum++;
        }
        return openNum;
    }
    // does the system percolate?   
    public boolean percolates() {
        if (isPercolated) 
            return true;
        if (unionInstance.connected(virtualTop, virtualBottom)) {
            isPercolated = true;
            return true;
        }
        return false;   
    }
    // test client (optional)   
    public static void main(String[] args) {
        Percolation perc = new Percolation(3);
        perc.open(1, 1);
        perc.open(1, 2);
        perc.open(2, 2);
        perc.open(2, 3);
        perc.open(3, 1);
        perc.open(3, 3);
        System.out.println(perc.percolates());
    }

}
