package datastructure.array;

public class TrappingRainWater {

    public int trappedRainWater(int[] height) {
        int[] maxLeftHeight = new int[height.length];
        int[] maxRightHeight = new int[height.length];

        maxLeftHeight[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeftHeight[i] = Math.max(height[i],maxLeftHeight[i-1]);
        }

        maxRightHeight[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >=0 ; i--) {
            maxRightHeight[i] = Math.max(height[i],maxRightHeight[i+1]);
        }

        int totalWaterTrapped = 0;
        for (int i = 0; i < height.length; i++) {
            totalWaterTrapped += Math.min(maxLeftHeight[i],maxRightHeight[i]) - height[i];
        }
        return  totalWaterTrapped;
    }
}
