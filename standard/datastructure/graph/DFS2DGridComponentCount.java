package datastructure.graph;

public class DFS2DGridComponentCount {

    public static void main(String[] args) {
        int a[][] = {
                {0, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0}
        };
        System.out.println(countComponent(a));

    }

    public static int countComponent(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int numberOfComponents = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && a[i][j] == 1) {
                    countComponentHelperUsingDfs(a, i, j, visited);
                    numberOfComponents++;
                }
            }
        }
        return numberOfComponents;
    }

    private static void countComponentHelperUsingDfs(int[][] a, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for (int p = -1; p <= 1; p++) {
            for (int q = -1; q <= 1; q++) {
                if (isValidPosition(i + p, j + q, a.length, a[0].length)
                        && !visited[i + p][j + q] && a[i + p][j + q] == 1) {
                    countComponentHelperUsingDfs(a, i + p, j + q, visited);
                }
            }
        }
    }

    private static boolean isValidPosition(int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        return true;
    }
}