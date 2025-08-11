// 🔍 Problem: Valid Parentheses
// 📝 Link: https://leetcode.com/problems/valid-parentheses/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Microsoft, Google, Facebook, Adobe

/*
👨‍💻 Problem Statement:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

🧾 Example:
Input: s = "()[]{}"
Output: true

Input: s = "(]"
Output: false

Input: s = "({[]})"
Output: true

*/

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

/*
🧠 Approach:
Use a stack to store opening brackets. 
When encountering a closing bracket, check if it matches the top of the stack.
If mismatched or stack is empty, return false.
At the end, stack should be empty for the string to be valid.

🛠️ Time Complexity: O(n) – single pass through the string.
🛠️ Space Complexity: O(n) – for the stack in the worst case.
✅ Status: Ready to push — file name: 20_ValidParentheses.java
*/
