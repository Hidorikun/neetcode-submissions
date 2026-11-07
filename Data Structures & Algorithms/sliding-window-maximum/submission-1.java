class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(); 
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // pop out of bounds
            if (deque.size() > 0 && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }

            // pop lesser items
            while (deque.size() > 0 && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            
            deque.addLast(i);
            
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.getFirst()];
            }
        }

        return result;
    }
}
