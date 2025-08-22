// 🔍 Problem: House Robber II
// 📝 Link: https://leetcode.com/problems/house-robber-ii/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Adobe

/*
👨‍💻 Problem Statement:
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 

Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses are broken into on the same night.

Given an integer array `nums` representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.

🧾 Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (2) and house 3 (2), so you rob house 2 (3).

🧾 Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (1) and house 3 (3).

🧾 Example 3:
Input: nums = [1,2,3]
Output: 3
*/

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        // Case 1: Rob houses from 0 to n-2 (exclude last house)
        int case1 = robLinear(nums, 0, nums.length - 2);

        // Case 2: Rob houses from 1 to n-1 (exclude first house)
        int case2 = robLinear(nums, 1, nums.length - 1);

        // Take maximum of both cases
        return Math.max(case1, case2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = temp;
        }
        return prev1;
    }
}

/*
🧠 Approach:
- Since houses are arranged in a circle, robbing the first and last house together is not possible.
- So, split into two cases:
    1. Rob houses excluding the last one (0 to n-2).
    2. Rob houses excluding the first one (1 to n-1).
- Solve both using the classic House Robber I DP (linear).
- Return the maximum of both cases.

🛠️ Time Complexity: O(n) – iterate through houses once per case
🛠️ Space Complexity: O(1) – constant space DP (only two variables used)
✅ Status: Accepted on LeetCode
*/
