class Solution {
    public int search(int[] nums, int target) {
        return binarySearchRecursive(nums, target, -1, nums.length);
    }

    public int binarySearchRecursive(int[] nums, int target, int l, int r) { 
        if (r - l == 1) {
            // we consider l and r to be outside of the search area
            // if they are one after another, there is no search area between them
            return -1; // so target is not there
        }

        int mid = l + (r - l) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        
        return nums[mid] < target // is on right side of mid ?
            ? binarySearchRecursive(nums, target, mid, r)
            : binarySearchRecursive(nums, target, l, mid);
    }
}
