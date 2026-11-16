class Solution {
    public int trap(int[] height) {
        int size = height.length;

        int[] leftMax = new int[size];
        int[] rightMax = new int[size];

        int trappedWater = 0;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                leftMax[i] = 0;
            } else {
                leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
            }
        }

        for (int i = size - 1; i >= 0; i--) {
            if (i == size - 1) {
                rightMax[i] = 0;
            } else {
                rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
            }
        }

        for (int i = 0; i < size; i++) {
            int diff = Math.min(leftMax[i], rightMax[i]) - height[i];

            if (diff < 0) {
                diff = 0;
            }

            trappedWater += diff;
        }

        return trappedWater;
    }
}
