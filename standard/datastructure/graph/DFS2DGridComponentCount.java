package datastructure.graph;

import datastructure.unionfind.UnionFind;

import java.util.HashSet;
import java.util.Set;

public class DFS2DGridComponentCount {

    public static void main(String[] args) {
//        int a[][] = {
//                {1, 1, 0, 0, 0},
//                {1, 1, 0, 0, 0},
//                {0, 0, 1, 0, 0},
//                {0, 0, 0, 1, 1}
//        };

        int a[][] = {
                {0, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 1}
        };
        System.out.println(countComponent(a));
        System.out.println(countComp(a));
        System.out.println(countComponentUsingUnionFind(a));

    }

    public static int countComp(int[][] a) {
        int count = 0;
        boolean[][] visited = new boolean[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if(!visited[i][j] && a[i][j]==1) {
                    helper(a,i,j,visited);
                    ++count;
                }
            }
        }
        return count;
    }



    public static void helper(int[][] a, int i, int j,boolean[][] visited) {
        if(!validIndices(a,i,j)) return;
        if(!visited[i][j] && a[i][j]==1) {
            visited[i][j] = true;
            helper(a,i-1,j,visited);
            helper(a,i+1,j,visited);
            helper(a,i,j-1,visited);
            helper(a,i,j+1,visited);
            helper(a,i-1,j-1,visited);
            helper(a,i-1,j+1,visited);
            helper(a,i+1,j-1,visited);
            helper(a,i+1,j+1,visited);
        }
    }

    private static boolean validIndices(int[][] a, int i, int j) {
        if(i>=0 && i<=a.length-1 && j>=0 && j<=a[0].length-1) return true;
        return false;
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


    public static int countComponentUsingUnionFind(int[][] a) {
        int R = a.length;
        int C = a[0].length;
        int N = R*C;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(a[i][j]==0) continue;
                // i,j
                //checking all neighbours
                for (int p = -1; p <= 1; p++) {
                    for (int q = -1; q <= 1; q++) {
                        if (isValidPosition(i + p, j + q, R, C) && a[i + p][j+q]==1) {
                            unionFind.union(cellVal(i,j, C), cellVal(i+p, j+q, C));
                        }
                    }
                }
            }
        }

        // counting component in union find
        Set<Integer> uniqueRoots = new HashSet<>();
        for(int k = 0; k < N; k++) {
            int i = k/C;
            int j = k%C;
            if(a[i][j]==1) uniqueRoots.add(unionFind.rootInPathCompression(k));
        }
        return uniqueRoots.size();
    }

    static int cellVal(int i, int j, int C) {
        return i*C+j;
    }


}