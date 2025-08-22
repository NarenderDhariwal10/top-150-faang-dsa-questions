// 🔍 Problem: Longest Increasing Subsequence
// 📝 Link: https://leetcode.com/problems/longest-increasing-subsequence/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Facebook

/*
👨‍💻 Problem Statement:
Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence derived from an array by deleting some or no elements 
without changing the order of the remaining elements.

🧾 Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

🧾 Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4
Explanation: The LIS is [0,1,2,3].

🧾 Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
Explanation: The LIS is [7].
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;

        // Each element is LIS of length 1 initially
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Build LIS using DP
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}

/*
🧠 Approach:
- Use Dynamic Programming.
- Let `dp[i]` = length of LIS ending at index `i`.
- Initialize all dp[i] = 1 (every element is LIS of length 1).
- For each element nums[i], check all previous nums[j] where j < i:
    - If nums[i] > nums[j], then nums[i] can extend the subsequence ending at j.
    - Update dp[i] = max(dp[i], dp[j] + 1).
- Answer = max value in dp[].

🛠️ Time Complexity: O(n^2) – double loop
🛠️ Space Complexity: O(n) – DP array
✅ Status: Accepted on LeetCode
*/
