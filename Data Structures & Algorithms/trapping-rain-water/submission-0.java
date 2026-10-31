class Solution {
    public int trap(int[] height) {
        int[] maxLeftWall = new int[height.length];
        int[] maxRightWall = new int[height.length];
        int result = 0;

        // compute left walls
        maxLeftWall[0] = 0;
        for (int i = 1; i < height.length; i++) {
            maxLeftWall[i] = Math.max(maxLeftWall[i - 1], height[i - 1]);
        }

        //compute right walls
        maxRightWall[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            maxRightWall[i] = Math.max(maxRightWall[i + 1], height[i + 1]);
        }

        //compute water
        for (int i = 0; i < height.length; i++) {
            result += Math.max(0, Math.min(maxLeftWall[i], maxRightWall[i]) - height[i]);
        }

        return result;
    }
}
