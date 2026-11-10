class Solution {
    public int findMin(int[] nums) {
        int l = 0; 
        int r = nums.length - 1;

        while (r - l > 1) {
            // System.out.println(String.valueOf(l) + " " + String.valueOf(r));
            int mid = l + (r - l) / 2;

            if (nums[mid] <= nums[r]) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return Math.min(nums[l], nums[r]);
    }
}
