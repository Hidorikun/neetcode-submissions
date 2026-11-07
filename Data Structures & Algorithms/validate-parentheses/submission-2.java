class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> opposite = Map.of(
            '(' , ')',
            '[' , ']',
            '{' , '}'
        );

        for (char c : s.toCharArray()) {
            if (!stack.empty() && opposite.containsKey(stack.peek()) && c == opposite.get(stack.peek())) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        return stack.empty();
    }
}
