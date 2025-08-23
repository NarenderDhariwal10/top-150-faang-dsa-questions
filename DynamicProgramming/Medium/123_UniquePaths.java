// 🔍 Problem: Unique Paths
// 📝 Link: https://leetcode.com/problems/unique-paths/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Microsoft, Apple, Adobe

/*
👨‍💻 Problem Statement:
There is a robot located at the top-left corner of an m x n grid (marked 'Start').
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish').
How many possible unique paths are there?

🧾 Example 1:
Input: m = 3, n = 7
Output: 28

🧾 Example 2:
Input: m = 3, n = 2
Output: 3
Explanation:
From the start position, there are two moves available: Right and Down.
- Right → Down → Down
- Down → Down → Right
- Down → Right → Down

🧾 Example 3:
Input: m = 1, n = 1
Output: 1
*/

/*
Constraints:
- 1 <= m, n <= 100
- The answer is guaranteed to be less than or equal to 2 * 10^9.
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // First row and first column → only 1 way to reach (all rights or all downs)
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}

/*
🧠 Approach:
- This is a **Dynamic Programming** problem.
- To reach cell (i, j), the robot can only come from:
  1. Top → (i-1, j)
  2. Left → (i, j-1)
- Therefore, dp[i][j] = dp[i-1][j] + dp[i][j-1].
- Base case: first row and first column = 1 (only one way to move straight).

🛠️ Time Complexity: O(m * n)  
🛠️ Space Complexity: O(m * n) → can be optimized to O(n) using 1D DP  
✅ Status: Accepted on LeetCode
*/
