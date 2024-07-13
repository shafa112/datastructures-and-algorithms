package algorithm.backtracking;

import util.Util;

import java.util.ArrayList;
import java.util.List;

/*BackTracking PsuedoCode
bool solve(configuration conf)
{
  if(no more choices)	//BASE CASE
	return (conf is goal state)
  for(all avialable choices)
  {
    try one choice c;
    //solve from here,if works out, you are done
    if(solve(conf with choice c made)) return true;
    else unmake choice c;
  }
  return false;  //tried all choices, no solution found
}*/
public class NQueen {

    public static void main(String[] args) {
        System.out.println(nQueens(4));
    }

    public static List<List<String>>  nQueens(int n) {
        List<List<String>>  answer = new ArrayList<>();
        String[][] board = new String[n][n];
        nQueens(n-1, board, answer);
        return answer;
    }


    public static void nQueens(int row, String[][] board, List<List<String>>  answer) {
        Util.printArray(board);
        if (row < 0) {
            System.out.println("Building answer");
            buildAnswer(board, answer);
            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            if (isIndexSafe(col, row, board)) {
                board[row][col] = "Q";
                nQueens(row - 1, board, answer);
                board[row][col] = null;
            }
        }
    }

    private static void buildAnswer(String[][] result, List<List<String>>  answer) {
        List<String> ans = new ArrayList<>();
        int queenCount = 0;
        for(int i =0; i < result.length; i++) {
            StringBuilder str = new StringBuilder("");
            for(int j=0; j< result[0].length; j++) {
                str.append(result[i][j] == null ? ".": "Q");
                if(result[i][j] == "Q") queenCount++;
            }
            ans.add(str.toString());
        }
        if(!ans.isEmpty() && queenCount == result.length) answer.add(ans);
    }

    private static boolean isIndexSafe(int col, int row, String[][] result) {
        // check if any Queen in ith col
        for (int j = 1; j < result.length; j++) {
            if(result[j][col]=="Q") return false;
        }

        // check if any Queen in nthRow
        for (int j = 0; j < result[0].length; j++) {
            if(result[row][j]=="Q") return false;
        }

        // check if any Queen in diagonals
        if(!safeDiagonals(col,row,result)) return false;

        return true;
    }

    private static boolean safeDiagonals(int col, int row, String[][] result) {
        return checkUpperLeftDiagonal(col-1,row-1,result)
                && checkUpperRightDiagonal(col+1,row-1,result)
                && checkBottomLeftDiagonal(col-1,row+1,result)
                && checkBottomRightDiagonal(col+1,row+1,result);
    }

    private static boolean checkUpperLeftDiagonal(int col, int row, String[][] result) {
        while(row>=0 && col>=0) {
            if(result[row][col]=="Q") return false;
            --row;
            --col;
        }
        return true;
    }

    private static boolean checkUpperRightDiagonal(int col, int row, String[][] result) {
        while(row>=0 && col<result[0].length) {
            if(result[row][col]=="Q") return false;
            else {
                --row;
                ++col;
            }
        }
        return true;
    }

    private static boolean checkBottomLeftDiagonal(int col, int row, String[][] result) {
        while(row<result.length && col>=0) {
            if(result[row][col]=="Q") return false;
            else {
                ++row;
                --col;
            }
        }
        return true;
    }

    private static boolean checkBottomRightDiagonal(int col, int row, String[][] result) {
        while(row<result.length && col<result[0].length) {
            if(result[row][col]=="Q") return false;
            else {
                ++row;
                ++col;
            }
        }
        return true;
    }
}
