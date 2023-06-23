package datastructure.array;


import java.util.Arrays;

public class PermutationOfCharArray {

    public static void main(String[] args) {
        char[] ch = {'a', 'b','c'};
        permutationOfCharArray(ch);
    }

    private static void permutationOfCharArray(char[] ch) {
        char[] dummy = putchInDummy(ch);
        System.out.println(Arrays.toString(ch));
        int i=0;
        for ( i = 0; i < ch.length-1; i++) {
            for (int j=i+1;j<ch.length;++j)
            {
                swap(dummy,i,j);
                System.out.println(Arrays.toString(dummy));
                dummy=putchInDummy(ch);;
            }
        }
        dummy=putchInDummy(ch);
        //System.out.println(i);
        if(i==ch.length-1) {
            for (int j = ch.length-2; j >0 ; j--) {
                swap(dummy,j,i);
                System.out.println(Arrays.toString(dummy));
                dummy=putchInDummy(ch);;
            }
            //System.out.println(Arrays.toString(ch));
        }
    }

    private static char[] putchInDummy(char[] ch) {
        char[] p = new char[ch.length];
        for (int i = 0; i < ch.length; i++) {
            p[i]=ch[i];
        }
        return p;
    }

    public static void swap(char[] dummy, int i, int j) {
        char temp=dummy[i];
        dummy[i]=dummy[j];
        dummy[j]=temp;
    }


}
