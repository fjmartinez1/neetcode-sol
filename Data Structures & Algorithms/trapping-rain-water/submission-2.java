class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxLeft = 0;
        int maxRight = 0;

        int trappedWater = 0;

        while (left < right) {
            maxLeft = Math.max(height[left], maxLeft);
            maxRight = Math.max(height[right], maxRight);

            if (maxLeft > maxRight) {
                int diff = maxRight - height[right];
                trappedWater += diff;
                right--;
            } else {
                int diff = maxLeft - height[left];
                trappedWater += diff;
                left++;
            }
        }
        
        return trappedWater;
    }
}
