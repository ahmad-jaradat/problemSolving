import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final int[] ts;
    private final int n;
    private final double mean;
    private final double stddev;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        this.n = n;
        ts = new int[trials];
        for (int i = 0; i < trials; i++) {
            int t = 0;
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                    t++;
                }
            }
            ts[i] = t;
        }
        mean = StdStats.mean(ts) / (n * n);
        stddev = StdStats.stddev(ts) / (n * n);
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - (Math.sqrt(1.96 * stddev) / Math.sqrt(ts.length));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + (Math.sqrt(1.96 * stddev) / Math.sqrt(ts.length));
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats PercolationStats = new PercolationStats(20, 30);
        System.out.println(PercolationStats.mean());
        System.out.println(PercolationStats.stddev());
        System.out.println(PercolationStats.confidenceHi());
        System.out.println(PercolationStats.confidenceLo());
    }

}
