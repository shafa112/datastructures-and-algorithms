package meta2;

public class TrappingRainWater {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        int trappedWater = 0;
        while(l < r) {
            if(leftMax <= rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                trappedWater += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax,height[r]);
                trappedWater += rightMax - height[r];
            }
        }
        return trappedWater;
    }
}
