class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int left = 0, right = s1.length() - 1;
        HashMap<Character, Integer> s1Freq = new HashMap<>();
        HashMap<Character, Integer> s2Freq = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1Freq.put(c, s1Freq.getOrDefault(c, 0) + 1);
        }

        for (int i = left; i <= right; i++) {
            char c = s2.charAt(i);
            s2Freq.put(c, s2Freq.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            if (s1Freq.equals(s2Freq)) {
                return true;
            }

            char leftChar = s2.charAt(left);
            s2Freq.replace(leftChar, s2Freq.get(leftChar) - 1);
            if (s2Freq.get(leftChar) == 0) {
                s2Freq.remove(leftChar);
            }

            left++;
            right++;

            if (right < s2.length()) {
                char rightChar = s2.charAt(right);
                s2Freq.put(rightChar, s2Freq.getOrDefault(rightChar, 0) + 1);
            }
        }

        return false;
    }
}
