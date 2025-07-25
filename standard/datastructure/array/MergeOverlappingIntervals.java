package datastructure.array;

import java.util.*;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        int[][] a = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        //int[][] ans1 = mergeOverlappingInterval(a);
        //int[][] ans2 = merge(a);
        /*for (int[] temp: ans2) {
            System.out.print(Arrays.toString(temp)+" ");
        }*/
        ArrayList<Interval> input = new ArrayList<>();
        for (int[] b : a) {
            input.add(new Interval(b[0],b[1]));
        }

        merge(input);
        System.out.println("ans");
        for (Interval interval: input) {
            System.out.println("start: "+interval.start+", end: "+ interval.end);
        }


    }





    public static int[][] merge(int[][] intervals) {
        Comparator<int[]> comparator = (a,b) -> a[0] - b[0];
        Arrays.sort(intervals, comparator);



        List<int[]> result = new ArrayList<>();
        int newInterval[] = intervals[0];
        result.add(newInterval);
        for(int interval[] : intervals)
        {
            if(interval[0] <= newInterval[1])
            {
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }
            else
            {
                //no overlap so the current interval will be put in answer and newInterval will always point to last added interval
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    /*
    * Approach: logic is same as above but too much clutter
    * */
    private static int[][] mergeOverlappingInterval(int[][] a) {
        Arrays.sort(a,(a1,a2) -> a1[0]-a2[0]);
        Stack<List<Integer>> s = new Stack<>();

        List<Integer> l = new ArrayList<>();
        l.add(a[0][0]);
        l.add(a[0][1]);
        s.add(l);

        for (int i = 0; i < a.length; i++) {
            if(a[i][0] <= s.peek().get(1)) {
                int end = Math.max(s.peek().get(1),a[i][1]);
                s.peek().set(1,end);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(a[i][0]);
                temp.add(a[i][1]);
                s.push(temp);
            }
        }
        //convert stack to array and send
        int rows = s.size();
        int cols = s.peek().size();
        int[][] ans = new int[rows][cols];

        for (int i = rows - 1; i >= 0; i--) {
            List<Integer> list = s.pop();
            for (int j = 0; j < cols; j++) {
                ans[i][j] = list.get(j);
            }
        }
        return ans;
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Comparator<Interval> byStart = (i1,i2)->(i1.start-i2.start);
        Collections.sort(intervals,byStart);
        System.out.println("sort");
        for (Interval interval: intervals) {
            System.out.println("start: "+interval.start+", end: "+ interval.end);
        }
        ArrayList<Interval> ans = new ArrayList<>();
        Interval newInterval = intervals.get(0);
        ans.add(newInterval);
        for(int i = 1; i < intervals.size(); ++i) {
            if(intervals.get(i).start <= newInterval.end) {
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            } else {
                newInterval = intervals.get(i);
                ans.add(newInterval);
            }
        }
        return ans;
    }

    static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}