class Solution {
    public int search(int[] nums, int target) {
        int l = 0; 
        int r = nums.length - 1;

        while (l <= r) { 
            int mid = l + (r - l) / 2;

            // System.out.println(String.valueOf(l) + " " + String.valueOf(r) + " " + String.valueOf(mid));
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) { // then interval [L, M] is normal
                // System.out.println("normal");
                if (nums[l] <= target && target < nums[mid]) { // then if t is inside, we search this interval
                    r = mid - 1;
                } else { // we search the other interval
                    l = mid + 1;
                }
            } else { // else interval [L, M] is inverted
                // System.out.println("inverted");
                if (target < nums[mid] || target > nums[r]) { // so if t is outside, we search the other interval
                    // System.out.println("A");
                    r = mid - 1;
                } else { 
                    // System.out.println("B");
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}
