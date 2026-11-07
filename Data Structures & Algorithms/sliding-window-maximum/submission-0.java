class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        result[0] = pq.peek();
        
        for (int i = k; i < nums.length; i++) {
            pq.remove(nums[i - k]);
            pq.add(nums[i]);
            result[i - k + 1] = pq.peek();  
        }

        return result;
    }
}
