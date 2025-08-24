// 🔍 Problem: Interleaving String
// 📝 Link: https://leetcode.com/problems/interleaving-string/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Facebook, Adobe

/*
👨‍💻 Problem Statement:
Given strings s1, s2, and s3, return true if s3 is formed by an interleaving of s1 and s2, 
otherwise return false.

Two strings s and t are interleaved to form s3 if s and t are divided into 
non-empty substrings such that:
- s = s1 + s2 + ... + sn
- t = t1 + t2 + ... + tm
- s3 = s1 + t1 + s2 + t2 + ... + sn + tm
  (for any valid n and m)

🧾 Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to form s3 is "aabcc" + "dbbca".

🧾 Example 2:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false

🧾 Example 3:
Input: s1 = "", s2 = "", s3 = ""
Output: true
*/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();

        if (m + n != s3.length()) return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Fill first row (using only s1)
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Fill first column (using only s2)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill remaining cells
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = s3.charAt(i + j - 1);
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == c) ||
                           (dp[i][j - 1] && s2.charAt(j - 1) == c);
            }
        }

        return dp[m][n];
    }
}

/*
🧠 Approach:
- Use Dynamic Programming (2D table).
- dp[i][j] = true if first i chars of s1 and first j chars of s2 can form first (i+j) chars of s3.
- Transition:
  - From top (dp[i-1][j]) if s1[i-1] matches s3[i+j-1].
  - From left (dp[i][j-1]) if s2[j-1] matches s3[i+j-1].
- Answer = dp[m][n].

🛠️ Time Complexity: O(m * n), where m = length of s1, n = length of s2
🛠️ Space Complexity: O(m * n) (can be optimized to O(min(m,n)))
✅ Status: Accepted on LeetCode
*/
