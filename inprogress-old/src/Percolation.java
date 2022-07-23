
public class Percolation {
    private final int ROW = 0;
    private final int COL = 0;
    private final boolean[][] openSites;
    private int numberOfOpenSite = 0;
    private final ParentUnion union;
    private final int n;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        this.n = n;
        openSites = new boolean[n][n];
        union = new ParentUnion(n * n + 1);
        for (int i = 1; i <= n; i++) {
            union.union(0, i);
            union.union(n * n + 1, n * (n - 1) + i);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row <= 0 || col <= 0)
            throw new IllegalArgumentException();
        if (!openSites[--row][--col])
            numberOfOpenSite++;

        openSites[row][col] = true;

        int currentSiteIndex = row * n + col + 1;

        if ((col < n - 1) && openSites[row][col + 1])
            union.union(currentSiteIndex, currentSiteIndex + 1);

        if ((col > 0) && openSites[row][col - 1])
            union.union(currentSiteIndex, currentSiteIndex - 1);

        if ((row < n - 1) && openSites[row + 1][col])
            union.union(currentSiteIndex, currentSiteIndex + n);

        if ((row > 0) && openSites[row - 1][col])
            union.union(currentSiteIndex, currentSiteIndex - n);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row <= 0 || col <= 0)
            throw new IllegalArgumentException();

        return openSites[--row][--col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row <= 0 || col <= 0)
            throw new IllegalArgumentException();

        return openSites[--row][--col] && union.find(0, row * n + col + 1);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSite;
    }

    // does the system percolate?
    public boolean percolates() {
        return union.find(n * n + 1, 0);
    }
}
