package datastructure.graph;

import datastructure.unionfind.UnionFind;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {

    public List<Integer> numIslands2X(int m, int n, int[][] positions) {
        List<Integer> answer = new ArrayList<>();
        int[][] grid = new int[m][n];
        UnionFind uf = new UnionFind(m*n);
        int currentIslandCount = 0;
        for(int i = 0; i < positions.length; i++) {
            int r = positions[i][0];
            int c = positions[i][1];
            if(grid[r][c] != 1) {
                grid[r][c]=1;
                // update connections with neighbours and get updated island count
                currentIslandCount = getUpdatedIslandCount(grid, r, c, uf, currentIslandCount);
            }
            answer.add(currentIslandCount);
        }
        return answer;
    }

    private static int getUpdatedIslandCount(int[][] grid, int r, int c, UnionFind uf, int currentIslandCount) {
        int islandCount = currentIslandCount + 1;
        int R = grid.length;
        int C = grid[0].length;
        int neighbours[][] = {
                {-1,0},
                {0, 1},
                {1, 0},
                {0, -1}
        };
        int currentCellVal = cellVal(r, c, C);
        for(int i = 0 ; i < neighbours.length; i++) {
            int x = r + neighbours[i][0];
            int y = c + neighbours[i][1];
            if(isValidPosition(x, y, R, C) && grid[x][y] == 1) {
                int neighbourCellVal = cellVal(x, y, C);
                if(!uf.isConnected(currentCellVal, neighbourCellVal)) {
                    uf.union(currentCellVal, neighbourCellVal);
                    islandCount--;
                }
            }
        }
        return islandCount;
    }

    private static int cellVal(int x, int y, int C) {
        return x*C+y;
    }

    private static boolean isValidPosition(int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        return true;
    }

}