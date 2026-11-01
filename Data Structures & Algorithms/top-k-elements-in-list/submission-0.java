class Solution {

    class NumberCount {
        int num;
        int count;

        NumberCount(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int n : nums) {
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<NumberCount> maxQueue = new PriorityQueue<>((a, b) -> b.count - a.count);

        frequency.entrySet().stream()
            .map(entry -> new NumberCount(entry.getKey(), entry.getValue()))
            .forEach(numberCount -> maxQueue.add(numberCount));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxQueue.poll().num;
        }

        return result;
    }
}
