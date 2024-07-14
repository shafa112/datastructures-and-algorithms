package datastructure.array;

import java.util.Arrays;

public class MaximumUnsortedSubArray {

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4, 5};
        int[] t1 = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60}; //3 and 8
        maximumUnsortedSubArray2(t1);

    }

    public static void maximumUnsortedSubArray2(int[] a) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        int firstInvalidIndex = -1;
        int secondInvalidIndex = -1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                if(firstInvalidIndex==-1) firstInvalidIndex=i;
                if(secondInvalidIndex==-1) secondInvalidIndex=i;
                if (min > a[i]) {
                    min = a[i];
                }
                if (max < a[i]) {
                    max = a[i];
                }
            }
        }

        System.out.println("min ele:"+min);
        System.out.println("first invalid index:"+firstInvalidIndex);

        int correctStartIndex = getCorrectIndexMin(a,0,firstInvalidIndex,min);
        int correctEndIndex = getCorrectIndexMax(a,secondInvalidIndex,a.length-1,max);
        System.out.println(correctStartIndex+" "+correctEndIndex);

    }

    private static int getCorrectIndexMin(int[] a, int start, int end, int element) {
        for (int i = start; i <= end; i++) {
            if(element<a[i]) return i;
        }
        return -1;
    }

    private static int getCorrectIndexMax(int[] a, int start, int end, int element) {
        for (int i = end; i >= start; i--) {
            if(element>a[i]) return i;
        }
        return -1;
    }
























    public static int[] maximumUnsortedSubArray(int[] nums) {
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i+1]) {
                startIndex = i;
                endIndex = i+1;
                break;
            }
        }

        int tempMax = -1;
        for (int i = startIndex+1; i < nums.length - 1; i++) {
            if(tempMax < nums[i]) tempMax = nums[i];
            if(nums[i]>nums[i+1]) endIndex = i+1;
            else {
                if(tempMax > nums[i+1]) endIndex = i+1;
            }
        }
        System.out.println("tempMax: "+tempMax);
        if(startIndex==-1) return new int[]{-1};
        return new int[]{startIndex,endIndex};
    }
}
