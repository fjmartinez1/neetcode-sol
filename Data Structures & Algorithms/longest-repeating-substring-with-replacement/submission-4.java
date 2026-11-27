class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int longest = 0;
        HashMap<Character, Integer> frequency = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            frequency.put(rightChar, frequency.getOrDefault(rightChar, 0) + 1);

            int highestFreq = Collections.max(frequency.values());
            int windowLength = right - left + 1;

            while (windowLength - highestFreq > k) {
                char leftChar = s.charAt(left);
                frequency.replace(leftChar, frequency.get(leftChar) - 1);
                left++;

                windowLength--;
                highestFreq = Collections.max(frequency.values());
            }
            
            longest = Math.max(longest, windowLength);
            right++;
        }

        return longest;

    }
}