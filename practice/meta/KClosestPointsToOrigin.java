package meta;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        kClosest(points,k);
    }

    public static int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> byDistance = (a,b) -> (int) ((Math.pow(b[0],2)+Math.pow(b[1],2)) - (Math.pow(a[0],2)+Math.pow(a[1],2)));
        PriorityQueue<int[]> pq = new PriorityQueue<>(byDistance);

        int i = 0;
        while(i < points.length) {
            if(pq.size()<k) {
                pq.add(points[i]);
            } else {
                int[] peek = pq.peek();
                if((Math.pow(points[i][0],2)+Math.pow(points[i][1],2)) < (Math.pow(peek[0],2)+Math.pow(peek[1],2))){
                    pq.remove();
                    pq.add(points[i]);
                }
            }
            ++i;
        }

        int[][] result = new int[k][2];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.remove();
        }

        return result;
    }
}
