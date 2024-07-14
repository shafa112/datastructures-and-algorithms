package algorithm.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CompleteCircuitGasStation {


    // TimeLimitExceeded
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        Comparator<Integer> byGas = (i, j) -> gas[j] - gas[i];
        PriorityQueue<Integer> pq = new PriorityQueue<>(byGas);
        for (int i = 0; i < n; i++) {
            pq.add(i);
        }
        while (!pq.isEmpty()) {
            int startStation = pq.remove();
            int tank = 0;
            int currStation = startStation;
            int nextStation = (currStation+1)%n;
            while (nextStation != startStation) {
                // Now I am at current station and updating values accordingly
                tank = tank + gas[currStation];
                int netFuelForNextStation = tank - cost[currStation];
                if(netFuelForNextStation < 0) break;
                // updating tank for next station
                tank = netFuelForNextStation;
                currStation = nextStation;
                nextStation = (currStation + 1) % n;
            }

            if(nextStation == startStation) {
                tank = tank + gas[currStation] - cost[currStation];
                if(tank >= 0) return startStation;
            }
        }
        return -1;
    }

    public static int canComplete(final int[] gas, final int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (sumGas < sumCost) {
            return -1;
        } else {
            return start;
        }
    }
}
