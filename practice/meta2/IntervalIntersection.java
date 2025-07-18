package meta2;

import java.util.*;

public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> l = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if(start <= end) {
                l.add(new int[]{start,end});
            }

            if(firstList[i][1] < secondList[j][1]) ++i;
            else ++j;
        }

        int[][] result = new int[l.size()][2];
        for(int k = 0; k < l.size(); ++k) {
            result[k][0] = l.get(k)[0];
            result[k][1] = l.get(k)[1];
        }
        return result;
    }
}
