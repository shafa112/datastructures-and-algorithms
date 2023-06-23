package array;

/*
 * Conditions : 1<=a[i]<=n, a.length = n-1, no duplicates
 *
 * Math solution: n*(n+1)/2-(sum(a))
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

    static int missingNumber(int[] a) {
        int x = 0, y = 0;
        for (int i = 0; i < a.length; ++i) {
            x ^= a[i];
        }
        for (int i = 1; i <= a.length; ++i) {
            y ^= i;
        }
        return x ^ y;
    }

    // Idea is to calculate  n*(n+1)/2-(sum(a))
    // Above can exceed integer limit, therefore calculating difference element by element
    // si: 1 2 3 4 ... n
    // ai  a1,a2, .. an-1
    // miss: summation(si)-summation(ai)
    // missing = summation(si-ai) + n

    // i/p: [0, n] where n is a.length
    // constraints: 0 <= a[i] <= n, a[i] should be unique, 1 <= n <= 10^4
    // [0]
    // missing 1

    static int missingNumber2(int[] a) {
        int missingNumber = 0;
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            missingNumber += (i+1 - a[i]);
        }
        return missingNumber;
    }

    public static void main(String[] args) {
        int[] a = {0};
        System.out.println(missingNumber(a));
        System.out.println(missingNumber2(a));
    }
}
