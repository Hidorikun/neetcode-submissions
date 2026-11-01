class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, List<Integer>> buckets = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (int n : nums) {
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }

        for (int n : frequency.keySet()) {
            buckets.putIfAbsent(frequency.get(n), new ArrayList<>());
            buckets.get(frequency.get(n)).add(n);
        }

        int n = nums.length;
        while (k > 0) {
            if (buckets.containsKey(n)) {
                result.addAll(buckets.get(n));
                k -= buckets.get(n).size();
            }
            n--;
        }

        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
