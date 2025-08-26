// 🔍 Problem: Palindromic Substrings
// 📝 Link: https://leetcode.com/problems/palindromic-substrings/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Adobe

/*
👨‍💻 Problem Statement:
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.

🧾 Example 1:
Input: s = "abc"
Output: 3
Explanation: Three palindromic substrings: "a", "b", "c".

🧾 Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic substrings: "a", "a", "a", "aa", "aa", "aaa".
*/

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        // Check substrings of length >= 2
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j]) count++;
            }
        }

        return count;
    }
}

/*
🧠 Approach :
- Use a DP table dp[i][j] = true if substring s[i..j] is palindrome.
- Steps:
  1. All single characters are palindromes → dp[i][i] = true.
  2. For substrings of length 2, check if both chars are equal.
  3. For substrings of length > 2, check if:
       s[i] == s[j] AND dp[i+1][j-1] is true.
  4. Count all palindromic substrings found.

🛠️ Time Complexity: O(n^2) → since we check all substrings
🛠️ Space Complexity: O(n^2) → DP table storage
✅ Status: Accepted on LeetCode
*/
