package gg;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    public int minMeetingRooms(int[][] intervals) {
        Comparator<Pair> byTime = (p1, p2) -> {
            if(p1.time != p2.time) return p1.time - p2.time;
            return p1.type - p2.type;
        };
        PriorityQueue<Pair> minTime = new PriorityQueue<>(byTime);
        for(int i = 0; i < intervals.length; ++i) {
            minTime.add(new Pair(intervals[i][0],1));
            minTime.add(new Pair(intervals[i][1],-1*1));
        }

        int n = 0;
        int min = 0;
        while(!minTime.isEmpty()) {
            Pair p = minTime.remove();
            if(p.type > 0) ++n;
            else --n;
            min = Math.max(min,n);
        }
        return min;
    }

    class Pair {
        public int time;
        public int type;
        public Pair(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }
}
