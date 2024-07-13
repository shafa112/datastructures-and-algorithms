package uber;

import java.util.*;

public class SquarePuzzleQ3Medium {

    public String[][] updateMat(String[][] mat) {
        int n = mat[0].length/4; // number of 4X4 grid
        List<SquareMat> list = new ArrayList<>();

        int startColIndex = 0;
        for(int i = 1; i<=n; ++i) {
            processSquare(startColIndex,mat,list);
            startColIndex = startColIndex+4;
        }
        sortMatrix(mat,list);
        return mat;
    }

    private void sortMatrix(String[][] mat, List<SquareMat> list) {
        Comparator<SquareMat> c = Comparator.comparingInt(s -> Integer.parseInt(s.grid[s.row][s.col]));
        Collections.sort(list,c);
        for (SquareMat sq: list) {
            print2DMat(sq.grid);
        }
        // todo : fill mat with list grids

    }

    private void print2DMat(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

    private void processSquare(int startColIndex, String[][] mat,List<SquareMat> list) {
        Map<Integer, Boolean> map = new HashMap<>();
        int missingNumber = -1;
        for(int i = 1; i <= 16; ++i) {
            map.put(i,false);
        }

        //processing square
        int r = -1;
        int c = -1;
        for(int i = 0; i < 4; ++i) {
            for (int j = startColIndex; j < startColIndex + 4; j++) {
                if(mat[i][j]=="?") {
                    r = i;
                    c = j;
                } else {
                    map.put(Integer.parseInt(mat[i][j]),true);
                }
            }
        }

        //traverse map to check missing number(value = false) and replace '?' in 1st square with it
        for(Map.Entry<Integer,Boolean> entry : map.entrySet()) {
            if(!entry.getValue()) {
                mat[r][c] = entry.getKey()+""; //replacing the missing value
                missingNumber = entry.getKey();
            }
        }

        String[][] grid = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = startColIndex, k = 0; j < startColIndex+4 && k<4; k++,j++) {
                grid[i][k] = mat[i][j];
            }
        }
        SquareMat squareMat = new SquareMat(grid, missingNumber,r,c%4);
        list.add(squareMat);
    }

    static class SquareMat{
        String[][] grid;
        int missingNumber;
        int row;
        int col;

        public SquareMat(String[][] grid, int missingNumber, int row, int col) {
            this.grid = grid;
            this.missingNumber = missingNumber;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        String[][] mat = {
                {"14","3","10","4","16","10","?","2","?","9","15","11"},
                {"16","7","8","2","1","4","8","3","3","16","7","13"},
                {"?","9","6","5","14","12","7","6","2","10","4","14"},
                {"15","1","13","12","9","15","5","13","1","8","12","6"}
        };
        SquarePuzzleQ3Medium s = new SquarePuzzleQ3Medium();
        s.updateMat(mat);
    }
}
