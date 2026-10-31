class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key = num[index], value = index
        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needle = target - nums[i];
            
            if (index.containsKey(needle)) { 
                return new int[] {index.get(needle), i};
            }

            index.put(nums[i], i);
        }

        return new int[]{};
    }
}
