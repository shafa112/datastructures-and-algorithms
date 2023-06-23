package datastructure.array;

import java.util.Arrays;

public class Sort0and1s {

    public static void main(String[] args) {
        int[] a = {1,0,0};
        System.out.println("unsorted: "+Arrays.toString(a));
        //sort0s1s(a);
        //System.out.println(Arrays.toString(a));
        int[] b = {0, 1, 2, 0, 1, 2};
        int[] c = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        //sort0s1s(a);
        sort0s1s2s(c);
        System.out.println(Arrays.toString(c));
    }

    private static void sort0sAnd1s(int[] a) {
        int i = 0,j = a.length-1;
        while(i < j) {
            if(a[i]>a[j]) {
                swap(a,i,j);
                ++i;
            }
            if(a[i]==a[j]) {
                if(a[i]==0) ++i;
                else --j;
            }
            if(a[i]<a[j]) ++i;
        }
    }

    private static void sort0s1s(int[] a) {
        int left =0, right=a.length-1;
        while(left<right) {
            while(a[left]==0 && left<right) ++left;
            while(a[right]==1 && left<right) --right;
            if(left<right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println("left:"+left);
        System.out.println("right:"+right);
    }

    private static void sort0s1s2s(int[] a) {
        int left =0, right=a.length-1;
        while(left<right) {
            while(a[left]==0 && left<right) ++left;
            while((a[right]==1 || a[right]==2) && left<right) --right;
            if(left<right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println("left:"+left);
        System.out.println("right:"+right);
        sort1s2s(a,left);
    }

    private static void sort1s2s(int[] a, int l) {
        int left =l, right=a.length-1;
        while(left<right) {
            while(a[left]==1 && left<right) ++left;
            while(a[right]==2 && left<right) --right;
            if(left<right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
    }

    private static void sort0sAnd1sAnd2s(int[] a) {
        int i = 0,j = a.length-1;
        while(i < j) {
            if((a[i]==1 || a[i]==2) && a[j]==0) {
                swap(a,i,j); ++i;
            }
            else if(a[i]==a[j]) {
                if(a[i]==1 || a[i]==2) --j;
                else ++i;
            }
            else if(a[i]==0 && (a[j]==1 || a[j]==2)) ++i;
            else --j;
        }
        System.out.println(a[i]+" "+i);
        sort1sAnd2s(a,i);
    }

    private static void sort1sAnd2s(int[] a,int start) {
        int i = start,j = a.length-1;
        while(i < j) {
            if(a[i]>a[j]) {
                swap(a,i,j);
                ++i;
            }
            if(a[i]==a[j]) {
                if(a[i]==1) ++i;
                else --j;
            }
            if(a[i]<a[j]) ++i;
        }
    }

    private static void swap(int[] a,int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
