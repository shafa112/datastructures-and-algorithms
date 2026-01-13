package gg;

public class ContainerMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        int area = 0;
        while(l < r) {
            area = (r-l)*Math.min(height[l],height[r]);
            max = Math.max(area,max);
            if(height[l] <= height[r]) ++l;
            else --r;
        }
        return max;
    }
}
