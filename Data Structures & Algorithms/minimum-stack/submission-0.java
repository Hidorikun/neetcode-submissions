class MinStack {

    Stack<Integer> numbers;
    Stack<Integer> mins; 

    public MinStack() {
        numbers = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {
        numbers.add(val);
        if (mins.empty() || val <= mins.peek()) {
            mins.add(val);
        }
    }
    
    public void pop() {
        int val = numbers.pop();
        if (val == mins.peek()) {
            mins.pop();
        }
    }
    
    public int top() {
        return numbers.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
