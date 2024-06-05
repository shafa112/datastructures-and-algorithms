package datastructure.array;

import java.util.*;

public class MinimumNumberOfPlatform {

    /*
     * Sort arrival time and dept time,
     * if train arrives do count++ and if train depts then do count -- in asc order.
     *
     * Time complexity.
     * nlogn(sort arrival array) +
     * nlogn(sort dept array) +
     * n (traversing the arrays)
     * */
    public static void minPlatforms(double[] arrival, double[] departure) {
        int count = 0;
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i = 1;
        int j = 0;
        count = 1;
        int max = 0;
        while (i < arrival.length && j < departure.length) {
            if (arrival[i] < departure[j]) {
                ++count;
                ++i;
            } else {
                --count;
                ++j;
            }
            max = Math.max(max, count);
        }
        System.out.println("min platform: " + max);
    }

    /*
     * Similar approach using different data-structure
     * */
    class Pair {
        int time;
        char ch;
        public Pair(int time, char ch) {
            this.time = time;
            this.ch = ch;
        }
    }

    public int minimumNumberOfPlatform(int arr[], int dep[]) {
        ArrayList<Pair> l = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            l.add(new Pair(arr[i], 'a'));
            l.add((new Pair(dep[i], 'd')));
        }

        Collections.sort(l, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.time == p2.time) return new Character(p1.ch).compareTo(new Character(p2.ch));
                return p1.time - p2.time;
            }
        });

        int platCount = 0;
        int maxPlatCount = 1;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).ch == 'a') {
                ++platCount;
            } else --platCount;
            if (maxPlatCount < platCount) maxPlatCount = platCount;
        }
        return maxPlatCount;

    }

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        MinimumNumberOfPlatform m = new MinimumNumberOfPlatform();
        System.out.println(m.minimumNumberOfPlatform(arr, dep));
    }
}
