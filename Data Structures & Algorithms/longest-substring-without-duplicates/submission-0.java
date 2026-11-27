class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int longest = 0;
        HashSet<Character> seen = new HashSet<>();

        while (right < s.length()) {
            if (!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right));
                int length = right - left + 1;

                longest = Math.max(longest, length);
                right++;
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return longest;
    }
}
