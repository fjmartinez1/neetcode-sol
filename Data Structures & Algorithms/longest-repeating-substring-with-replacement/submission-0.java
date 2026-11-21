class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0;
        int maxFrequency = 0;
        int longest = 0;

        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'A';
            counts[index]++;
            maxFrequency = Math.max(maxFrequency, counts[index]);

            while (right - left + 1 - maxFrequency > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}