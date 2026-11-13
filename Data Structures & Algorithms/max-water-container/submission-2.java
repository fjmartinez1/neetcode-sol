class Solution {
    public int maxArea(int[] heights) {

        int maxArea = -1;
        int left = 0;
        int right = heights.length - 1;
        
        while (left < right) {
            int area = (right - left) * Math.min(heights[left], heights[right]);

            maxArea = Math.max(area, maxArea);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}
