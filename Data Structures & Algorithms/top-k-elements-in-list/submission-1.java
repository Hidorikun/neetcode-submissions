class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int n : nums) {
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(
            (a, b) -> frequency.get(b) - frequency.get(a)
        );

        frequency.keySet().stream()
            .forEach(num -> maxQueue.add(num));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxQueue.poll();
        }

        return result;
    }
}
