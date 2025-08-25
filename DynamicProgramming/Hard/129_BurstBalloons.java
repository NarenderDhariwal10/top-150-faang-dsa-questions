// 🔍 Problem: Burst Balloons
// 📝 Link: https://leetcode.com/problems/burst-balloons/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Google, Amazon, Microsoft, Facebook

/*
👨‍💻 Problem Statement:
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number 
on it represented by an array nums. You are asked to burst all the balloons.

If you burst the i-th balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. 
If i - 1 or i + 1 goes out of bounds, treat it as if there is a balloon with value 1. 

Return the maximum coins you can collect by bursting the balloons wisely.
*/

/*
🧾 Example 1:
Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] → add virtual balloons [1, 3, 1, 5, 8, 1]
Optimal order: burst balloons at index 1, 5, 3, 4 (or equivalent)
Max coins = 167

🧾 Example 2:
Input: nums = [1,5]
Output: 10
Explanation:
nums = [1,5] → add virtual balloons [1,1,5,1]
Max coins = 10
*/

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Add 1 before and after nums to simplify edge cases
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // DP table: dp[left][right] = max coins from interval (left, right)
        int[][] dp = new int[n + 2][n + 2];

        // length is the interval size
        for (int len = 2; len <= n + 1; len++) {
            for (int left = 0; left <= n + 1 - len; left++) {
                int right = left + len;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                        arr[left] * arr[k] * arr[right] + dp[left][k] + dp[k][right]);
                }
            }
        }

        return dp[0][n + 1];
    }
}

/*
🧠 Approach :
- Insert virtual balloons with value 1 at both ends.
- Define dp[left][right] = maximum coins we can get by bursting all balloons strictly between (left, right).
- Transition:
  For each balloon k between (left, right):
    dp[left][right] = max(dp[left][right], arr[left] * arr[k] * arr[right] + dp[left][k] + dp[k][right])
- We consider each balloon as the "last to burst" in its interval.
- Answer is dp[0][n+1].

🛠️ Time Complexity: O(n^3), where n = number of balloons
🛠️ Space Complexity: O(n^2) for DP table
✅ Status: Accepted on LeetCode
*/
