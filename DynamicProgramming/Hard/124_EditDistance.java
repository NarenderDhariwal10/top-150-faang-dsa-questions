// 🔍 Problem: Edit Distance
// 📝 Link: https://leetcode.com/problems/edit-distance/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Google, Microsoft, Amazon, Facebook, Apple

/*
👨‍💻 Problem Statement:
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:
1. Insert a character
2. Delete a character
3. Replace a character

🧾 Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3

🧾 Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5

🧾 Example 3:
Input: word1 = "abc", word2 = "yabd"
Output: 2
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i; // deleting all chars
        for (int j = 0; j <= n; j++) dp[0][j] = j; // inserting all chars

        // DP filling
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // no operation needed
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // replace
                                  Math.min(dp[i - 1][j],     // delete
                                           dp[i][j - 1]));   // insert
                }
            }
        }

        return dp[m][n];
    }
}

/*
🧠 Approach:
- Use Dynamic Programming to build a table dp[i][j] where:
  - i = prefix length of word1
  - j = prefix length of word2
  - dp[i][j] = min operations to convert word1[0..i-1] to word2[0..j-1]
- If characters match, no operation needed → dp[i][j] = dp[i-1][j-1].
- Else choose min of:
  1. Replace last char → dp[i-1][j-1] + 1
  2. Delete last char from word1 → dp[i-1][j] + 1
  3. Insert last char from word2 → dp[i][j-1] + 1

🛠️ Time Complexity: O(m * n)
🛠️ Space Complexity: O(m * n) (can be optimized to O(min(m, n)))
✅ Status: Accepted on LeetCode
*/
