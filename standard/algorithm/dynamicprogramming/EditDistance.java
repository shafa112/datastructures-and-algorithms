package algorithm.dynamicprogramming;


import java.util.Arrays;

// Levenshtein Distance ("Edit Distance")
// ref: https://youtu.be/Dd_NgYVOdLk
public class EditDistance {

    /*
     * Note: Consider below ith string is getting converted to jth string
     * Also, insertion/deletion/replacement operation is taking place in ith string
     *
     * Insertion case
     * After a character is inserted to i that means i+1 character is good now with respect to j,
     * and now we are left with problem i, j-1
     *
     * Deletion case
     * After a character is deleted in ith string, we are left i-1
     *
     * e(i,j) = Min { e(i-1, j) + D
     *                e(i, j-1) + I
     *                e(i-1, j-1) + R if(first[i]!=second[j])
     *                e(i-1, j-1) if(first[i]=second[j])
     *              }
     *
     * d : deletion cost
     * r : replacement cost
     * i : insertion cost
     */
    static int editDistance(String first,String second){
        int m  = first.length();
        int n = second.length();
        int e[][] = new int[m+1][n+1];
        //first col initialization where second string is empty
        for(int i = 1; i<=m ; i++) e[i][0]=i;
        // first row initialization where first string is empty
        for(int j = 1; j<=n ; j++) e[0][j]=j;

        for(int i = 1; i <= m ; i++){
            for(int j = 1; j <= n ;j++){
                if(first.charAt(i-1)!=second.charAt(j-1)){
                    e[i][j]=min(e[i-1][j], e[i][j-1], e[i-1][j-1])+1;
                }else{
                    e[i][j]=min(e[i-1][j]+1, e[i][j-1]+1, e[i-1][j-1]);
                }
            }
        }

        return e[m][n];
    }

    static int min(int... x) {
        return Arrays.stream(x).min().getAsInt();
    }
}
