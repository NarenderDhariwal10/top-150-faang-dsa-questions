// 🔍 Problem: Valid Parentheses
// 📝 Link: https://leetcode.com/problems/valid-parentheses/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Google, Microsoft, Adobe

/*
👨‍💻 Problem Statement:
Given a string `s` containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

An input string is valid if:
1. Open brackets are closed by the same type of brackets.
2. Open brackets are closed in the correct order.
3. Every closing bracket has a corresponding open bracket of the same type.

🧾 Example:
Input: s = "()[]{}"
Output: true

Input: s = "(]"
Output: false

Input: s = "([)]"
Output: false
*/

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // Handle closing brackets
            else {
                if (stack.isEmpty()) return false; // no matching opening

                char open = stack.pop();
                if ((ch == ')' && open != '(') || 
                    (ch == '}' && open != '{') || 
                    (ch == ']' && open != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // valid if no leftover open brackets
    }
}

/*
🧠 Approach:
- Use a stack to keep track of the last unmatched opening bracket.
- For every closing bracket, check if it matches the last opening bracket.
- If all brackets are matched correctly, the stack should be empty at the end.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(n) – stack usage in the worst case

✅ Status: Accepted on LeetCode
*/
