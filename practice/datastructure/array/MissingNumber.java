package array;
/*
* Conditions : 1<=a[i]<=n, a.length = n-1, no duplicates
*
* Math soln: n*(n+1)/2-(sum(a))
*
* XOR: diff bit then true, else false
* XOR Table
* x y z
* 0 0 0
* 0 1 1
* 1 0 1
* 1 1 0
*
* XOR soln implemented below
*
* */
public class MissingNumber {

    static int missingNumber(int[] a, int n) {
        int x=0,y=0;
        for(int i = 0; i < a.length; ++i) {
            x^=a[i];
        }
        for(int i = 1; i <= n; ++i) {
            y^=i;
        }
        return x^y;
    }

    //subtracting one by one
    static int missingNumber2(int[] a, int n) {
        int m =0;
        int j=0;
        for(int i=0;i<a.length;++i) {
            m+=(j-a[i]);
            ++j;
        }
        m+=j;
        return m;
    }

    public static void main(String[] args) {
        int[] a = {3,0,1};
        System.out.println(missingNumber2(a,3));
    }
}
