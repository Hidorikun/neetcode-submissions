class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = -1; 
        int r = m * n;

        while (r - l > 1) {
            int mid = l + (r - l) / 2;
            
            if (get(matrix, mid) == target) {
                return true;
            }

            if (get(matrix, mid) < target) {
                l = mid;
            } else {
                r = mid;
            }

        }

        return false;
    }

    private int get(int[][] matrix, int cell) {
        int n = matrix[0].length;

        return matrix[cell / n][cell % n];
    }
}
