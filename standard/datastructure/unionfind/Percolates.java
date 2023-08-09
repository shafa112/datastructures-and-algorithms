package datastructure.unionfind;

// https://www.coursera.org/learn/algorithms-part1/lecture/OLXM8/union-find-applications
// Application of union find

// Idea is to imagine 2-d grid in the input with sequencing 1,2,3...R*C
// We will also imagine two more nodes 0 which will be connected to all open sites in the first row
// And another node R*C+1 to all open sites in the last row
// if 0 and (R*C+1)th nodes are connected, it means it percolates
public class Percolates {
    
    public static void main(String[] args) {
        // this should percolate
        int[][] a = {
                {0,0,0,1},
                {1,0,1,1},
                {0,1,1,0},
                {0,1,0,0},
        };
        System.out.println(percolates(a));
    }

    // idea is to imagine 2-D array as 1-D array where each cell value is 1,2,3,...
    // implement getCellValue accordingly
    public static boolean percolates(int[][] a) {
        int R = a.length;
        int C = a[0].length;
        UnionFind uf = new UnionFind(R*C+2);

        // Connect first row with open site to 0th node in Union find
        // Connect last row with open site to (R*C+1)th node in Union find
        for(int j = 0; j < C; j++) {
            if(a[0][j] == 1) {
                uf.union(0, getCellValue(0, j, R, C));
            }
            if(a[R-1][j] == 1) {
                uf.union(R*C+1, getCellValue(R-1, j, R, C));
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(a[i][j]==1) {
                    unionAllNeighbours(a, i, j, uf, R, C);
                }
            }
        }
        return uf.isConnected(0, R*C+1);
    }

    private static void unionAllNeighbours(int[][] a, int x, int y, UnionFind uf, int R, int C) {
        for (int p = -1; p <= 1; p++) {
            for (int q = -1; q <= 1; q++) {
                // ignoring diagonal elements
                if(Math.abs(p) + Math.abs(q) != 2) {
                    int i = x+p;
                    int j = y + q;
                    if(isValidPosition(i, j, R, C) && a[i][j] == 1) {
                        int ijCellNumber = getCellValue(i, j, R, C);
                        int xyCellNumber = getCellValue(x, y, R, C);
                        uf.union(ijCellNumber, xyCellNumber);
                    }
                }
            }
        }
    }

    static int getCellValue(int i, int j, int R, int C) {
        return (i*C)+j+1;
    }

    private static boolean isValidPosition(int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        return true;
    }
}
