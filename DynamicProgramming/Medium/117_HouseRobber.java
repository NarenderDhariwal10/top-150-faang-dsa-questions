// 🔍 Problem: House Robber
// 📝 Link: https://leetcode.com/problems/house-robber/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Facebook, Google

/*
👨‍💻 Problem Statement:
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed. 
The only constraint is that adjacent houses have security systems connected, 
and it will automatically contact the police if two adjacent houses are robbed.

Given an integer array `nums` representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.

🧾 Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total = 4.

🧾 Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9), rob house 5 (money = 1).
Total = 12.
*/

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0;  // max till i-2
        int prev1 = 0;  // max till i-1

        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + num);
            prev2 = temp;
        }

        return prev1;
    }
}

/*
🧠 Approach:
- Classic **Dynamic Programming**.
- At each house, you have two choices:
  1. Rob this house → add its money to the max value from house i-2.
  2. Skip this house → take the max value from house i-1.
- Transition: dp[i] = max(dp[i-1], dp[i-2] + nums[i])
- Optimize space by only keeping last two states.

🛠️ Time Complexity: O(n) – iterate through all houses
🛠️ Space Complexity: O(1) – only using two variables
✅ Status: Accepted on LeetCode
*/
