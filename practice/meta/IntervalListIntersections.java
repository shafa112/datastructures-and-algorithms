package meta;

import util.Util;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public static void main(String[] args) {
        int[][] firstList = {{8,15}};
        int[][] secondList = {{2, 6},{8,10},{12,20}};
        int[][] ans = intervalIntersection(firstList, secondList);
        System.out.println("final answer");
        Util.printArray(ans);
    }

    public static int[][] intervalIntersection2(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int m = firstList.length;
        int n = secondList.length;
        int i = 0;
        int j = 0;
        while(i < m && j < n) {
            int start = Math.max(firstList[i][0],secondList[j][0]);
            int end = Math.min(firstList[i][1],secondList[j][1]);
            if(start <= end) result.add(new int[]{start,end});

            if(firstList[i][1] < secondList[j][1]) ++i;
            else ++j;
        }
        int[][] ans = convertListTo2DArray2(result);
        return ans;
    }


    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<Pair> result = new ArrayList<>();
        int m = firstList.length;
        int n = secondList.length;
        int i = 0;
        int j = 0;
        while(i < m && j < n) {
            if(firstList[i][0] <= secondList[j][0]) {
                if(firstList[i][1] >= secondList[j][0]) {
                    result.add(new Pair(secondList[j][0],Math.min(firstList[i][1],secondList[j][1])));
                } // iska else means no intersection

                if(firstList[i][1] == secondList[j][1]) {
                    ++i;
                    ++j;
                } else if(firstList[i][1] > secondList[j][1]) {
                    ++j;
                } else ++i;
            } else {
                if(secondList[j][1] >= firstList[i][0]) {
                    result.add(new Pair(firstList[i][0],Math.min(firstList[i][1],secondList[j][1])));
                }

                if(secondList[j][1] == firstList[i][1]) {
                    ++i;
                    ++j;
                } else if(secondList[j][1] > firstList[i][1]) {
                    ++i;
                } else ++j;
            }
            System.out.println("printing List");
            System.out.println(result);
        }

        int[][] ans = convertListTo2DArray(result);
        return ans;
    }

    private static int[][] convertListTo2DArray(List<Pair> result) {
        int[][] ans = new int[result.size()][2];
        for (int k = 0; k < result.size(); k++) {
            ans[k][0] = result.get(k).start;
            ans[k][1] = result.get(k).end;
        }
        return ans;
    }

    private static int[][] convertListTo2DArray2(List<int[]> result) {
        int[][] ans = new int[result.size()][2];
        for (int k = 0; k < result.size(); k++) {
            ans[k][0] = result.get(k)[0];
            ans[k][1] = result.get(k)[1];
        }
        return ans;
    }

    static class Pair {
        int start;
        int end;

        public Pair(int i, int j) {
            this.start = i;
            this.end = j;
        }

        @Override
        public String toString() {
            return "Pair { " +
                    " start=" + start +
                    ", end=" + end +
                    " }";
        }
    }
}
