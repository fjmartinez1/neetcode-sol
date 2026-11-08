class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> frequency = new HashMap<>();
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] kFrequent = new int[k];
        int j = 0;

        for (int i = buckets.length - 1; i >= 0 && j < k; i--) {
            if (buckets[i] == null) {
                continue;
            }

            for (int num : buckets[i]) {
                kFrequent[j] = num;
                j++;

                if (j == k) {
                    break;
                }
            }
        }

        return kFrequent;  
    }
}