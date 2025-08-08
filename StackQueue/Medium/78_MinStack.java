// 🔍 Problem: Min Stack
// 📝 Link: https://leetcode.com/problems/min-stack/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Facebook, Google

/*
👨‍💻 Problem Statement:
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:
- void push(int val) pushes the element val onto the stack.
- void pop() removes the element on the top of the stack.
- int top() gets the top element of the stack.
- int getMin() retrieves the minimum element in the stack.

🧾 Example:
Input:
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output:
[null,null,null,null,-3,null,0,-2]

*/

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minstack.isEmpty() || val <= minstack.peek()) {
            minstack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minstack.peek())) {
            minstack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}

/*
🧠 Approach:
Use two stacks:
- `stack`: to store all elements
- `minstack`: to keep track of the current minimums

Push: Push onto both stacks if new value is <= current min  
Pop: Pop from both if top is equal to min  
Top: Return top of main stack  
getMin: Return top of min stack

🛠️ Time Complexity: O(1) for all operations  
🛠️ Space Complexity: O(n)

✅ Status: Accepted on LeetCode
*/
