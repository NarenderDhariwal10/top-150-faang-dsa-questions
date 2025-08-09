// 🔍 Problem: Evaluate Reverse Polish Notation
// 📝 Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Facebook, Microsoft

/*
👨‍💻 Problem Statement:
Given an array of strings `tokens` that represent an arithmetic expression in Reverse Polish Notation (RPN), evaluate the expression and return the integer result.

The valid operators are `+`, `-`, `*`, `/`.
Operands are integers (positive, negative, or zero).

🧾 Example:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); // Stack to hold operands

        for (String token : tokens) {
            // If the token is an operator, pop two numbers and apply operation
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } 
            else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } 
            else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } 
            else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b); // Integer division truncates toward zero
            } 
            else {
                // Otherwise, it's a number → push to stack
                stack.push(Integer.parseInt(token));
            }
        }

        // Final result is the only element left in stack
        return stack.pop();
    }
}

/*
🧠 Approach:
- Use a stack to store operands.
- When an operator is found, pop top two elements, apply operation, push result back.
- Continue until all tokens are processed.

🛠️ Time Complexity: O(n) → Each token processed once
🛠️ Space Complexity: O(n) → Stack stores operands

✅ Status: Accepted on LeetCode
*/
