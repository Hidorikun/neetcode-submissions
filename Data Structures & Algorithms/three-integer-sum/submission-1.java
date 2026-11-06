class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; //we have already computed a list starting with nums[i]
            }

            int j = i + 1;
            int k = nums.length - 1;
            int t = 0 - nums[i];

            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                } else if (nums[j] + nums[k] < t) {
                    j++;
                } else if (nums[j] + nums[k] > t) {
                    k--;
                } else if (nums[j] + nums[k] == t) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                }
            }
        }

        return result;
    }
}
