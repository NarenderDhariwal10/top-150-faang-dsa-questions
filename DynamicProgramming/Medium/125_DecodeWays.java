// 🔍 Problem: Decode Ways
// 📝 Link: https://leetcode.com/problems/decode-ways/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Facebook

/*
👨‍💻 Problem Statement:
A message containing letters from A-Z can be encoded using the following mapping:
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"

To decode an encoded message, all the digits must be grouped and mapped back into letters using the reverse of the mapping above.
For example, "11106" can be mapped into:
- "AAJF" with grouping (1 1 10 6)
- "KJF" with grouping (11 10 6)

Note that the grouping (1 11 06) is invalid because "06" cannot be mapped (leading zero is invalid).

Given a string s containing only digits, return the number of ways to decode it.

🧾 Example 1:
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

🧾 Example 2:
Input: s = "226"
Output: 3
Explanation: "226" could be "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

🧾 Example 3:
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped because of leading zero.
*/

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        
        // dp[i] = number of ways to decode up to index i
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty string has 1 way to decode
        
        // First character check
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            
            // If one digit forms a valid character (1-9)
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            
            // If two digits form a valid character (10-26)
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}

/*
🧠 Approach:
- Use Dynamic Programming:
  - dp[i] = number of ways to decode string up to index i.
  - Base case: dp[0] = 1 (empty string has 1 way).
  - dp[1] depends on whether the first char is '0' or not.
  - Transition:
    1. If one-digit number (last char) is valid (1–9), add dp[i-1].
    2. If two-digit number (last two chars) is valid (10–26), add dp[i-2].
- Return dp[n].

🛠️ Time Complexity: O(n), where n = length of s
🛠️ Space Complexity: O(n) (can be optimized to O(1) using two variables)
✅ Status: Accepted on LeetCode
*/
