class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int longest = 1;

        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            seen.add(nums[i]);
        }

        for (int num : seen) {
            if (seen.contains(num - 1)) {
                continue;
            }

            int count = 1;
            
            while (seen.contains(num + 1)) {
                num++;
                count++;
            }

            longest = Math.max(count, longest);
        }

        return longest;
    }
}




