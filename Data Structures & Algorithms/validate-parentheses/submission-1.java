class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> opposite = Map.of(
            '(' , ')',
            '[' , ']',
            '{' , '}'
        );

        for (char c : s.toCharArray()) {
            if (!stack.empty() && c == opposite.getOrDefault(stack.peek(), 'a')) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        return stack.empty();
    }
}
