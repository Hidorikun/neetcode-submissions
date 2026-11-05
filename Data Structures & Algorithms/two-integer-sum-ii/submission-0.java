class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int needleIndex = indexOf(numbers, target - numbers[i], i, numbers.length);
            if (needleIndex > -1) {
                return new int[]{i + 1, needleIndex + 1};
            }
        }

        return new int[2];
    }

    private int indexOf(int[] numbers, int number, int left, int right) {
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (numbers[mid] <= number) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return numbers[left] == number ? left : -1;
    }
}
