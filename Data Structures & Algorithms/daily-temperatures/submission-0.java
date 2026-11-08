class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                result[stack.peek()] = i - stack.pop();
            }

            stack.add(i);
        }

        return result;
    }
}
