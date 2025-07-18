package meta;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverage {

    Queue<Integer> q;
    int windowSize;
    int windowSum;

    public MovingAverage(int size) {
        windowSize = size;
        q = new ArrayDeque<>();
    }

    public double next(int val) {
        windowSum += val;
        q.add(val);
        if(q.size() > windowSize)  {
            windowSum -= q.remove();
        }

        return (double)windowSum/q.size();
    }
}
