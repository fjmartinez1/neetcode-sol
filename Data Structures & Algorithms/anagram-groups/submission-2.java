class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];

            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }

            anagrams.get(key).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }
}