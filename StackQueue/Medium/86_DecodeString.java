// 🔍 Problem: Decode String
// 📝 Link: https://leetcode.com/problems/decode-string/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Meta, Google, Microsoft, Adobe

/*
👨‍💻 Problem Statement:
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets 
is repeated exactly k times. k is a positive integer. You may assume that the input string 
is always valid and no extra spaces exist.

🧾 Example:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Input: s = "3[a2[c]]"
Output: "accaccacc"

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
*/

public class Solution {
    public String decodeString(String s) {
        StringBuilder currentString = new StringBuilder();
        java.util.Stack<Integer> countStack = new java.util.Stack<>();
        java.util.Stack<StringBuilder> stringStack = new java.util.Stack<>();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // Build multi-digit number
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
}

/*
🧠 Approach:
- Use two stacks: one for counts and one for strings.
- When encountering a digit, build the number `k`.
- When encountering `[`, push `k` and the current string to stacks and reset them.
- When encountering `]`, pop values from stacks and repeat the substring.
- Append normal characters directly to the current string.

🛠️ Time Complexity: O(n) – each character is processed once.
🛠️ Space Complexity: O(n) – stacks store intermediate strings and counts.
*/
