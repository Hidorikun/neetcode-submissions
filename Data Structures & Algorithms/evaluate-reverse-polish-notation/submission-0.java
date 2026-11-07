class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b;

        for (String token : tokens) {
            switch (token) {
                case "+" :
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a + b);
                    break;
                case "-" :
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a - b);
                    break;
                case "*" :
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a * b);
                    break;
                case "/" : 
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a / b);
                    break;
                default : 
                    stack.add(Integer.valueOf(token));
                    break;
            }

        }

        return stack.peek();
    }
}
