// 🔍 Problem: Longest Palindromic Substring
// 📝 Link: https://leetcode.com/problems/longest-palindromic-substring/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Adobe, Apple

/*
👨‍💻 Problem Statement:
Given a string s, return the longest palindromic substring in s.

A string is called a palindrome if it reads the same forward and backward.

🧾 Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

🧾 Example 2:
Input: s = "cbbd"
Output: "bb"

🧾 Example 3:
Input: s = "a"
Output: "a"

🧾 Example 4:
Input: s = "ac"
Output: "a"
*/

/*
Constraints:
- 1 <= s.length <= 1000
- s consists of only digits and English letters.
*/

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;

        // Single characters are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // Check substrings of length > 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // ending index

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}

/*
🧠 Approach:
- Use Dynamic Programming to store whether substring s[i...j] is a palindrome.
- Base Cases:
    - Single character substrings are palindromes.
    - Two-character substrings are palindromes if both characters are equal.
- For longer substrings (length ≥ 3):
    - s[i...j] is palindrome if s[i] == s[j] and s[i+1...j-1] is palindrome.
- Track the longest palindrome substring as we fill the DP table.

🛠️ Time Complexity: O(n^2) – filling DP table for all substrings
🛠️ Space Complexity: O(n^2) – DP table of size n x n
✅ Status: Accepted on LeetCode
*/
