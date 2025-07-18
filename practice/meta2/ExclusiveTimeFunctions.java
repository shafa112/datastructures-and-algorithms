package meta2;

import java.util.*;

public class ExclusiveTimeFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int executionTimes[] = new int[n];
        Stack<Integer> callstack = new Stack<>();
        int prev_time = 0;

        for(String log : logs) {
            String[] log_parts = log.split(":");
            int id = Integer.parseInt(log_parts[0]);
            String type = log_parts[1];
            int time = Integer.parseInt(log_parts[2]);

            if(type.equals("start")) {
                if(!callstack.isEmpty()) executionTimes[callstack.peek()] += time - prev_time;
                prev_time = time;
                callstack.push(id);
            } else {
                if(!callstack.isEmpty()) executionTimes[callstack.peek()] += time - prev_time + 1;
                if(!callstack.isEmpty()) callstack.pop();
                prev_time = time + 1;
            }
        }
        return executionTimes;
    }
}
