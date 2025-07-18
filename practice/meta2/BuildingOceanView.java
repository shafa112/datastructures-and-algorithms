package meta2;

import java.util.*;

public class BuildingOceanView {

    public int[] findBuildings(int[] heights) {
        int n = heights.length;

        int rightmax = heights[n-1];
        List<Integer> l = new ArrayList<>();

        l.add(n-1);
        for(int i = n-2; i >= 0; --i) {
            if(heights[i] > rightmax) {
                rightmax = heights[i];
                l.add(i);
            }
        }

        int[] output = new int[l.size()];
        int k = l.size() - 1;
        for(int i : l) {
            output[k--] = i;
        }
        return output;
    }
}
