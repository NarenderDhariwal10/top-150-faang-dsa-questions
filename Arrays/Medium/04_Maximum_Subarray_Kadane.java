// 🔍 Problem: Maximum Subarray (Kadane's Algorithm)
// 📝 Link: https://leetcode.com/problems/maximum-subarray/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Microsoft, Adobe

/*
👨‍💻 Problem Statement:
Given an integer array `nums`, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

🧾 Example:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum = 6.
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;                            // Running sum of current subarray
        int maxi = Integer.MIN_VALUE;           // Maximum sum found so far

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];                     // Add current number to sum
            maxi = Math.max(maxi, sum);         // Update max sum if needed
            if (sum < 0) {
                sum = 0;                        // Reset sum if it becomes negative
            }
        }

        return maxi;
    }
}

/*
🧠 Approach: Kadane’s Algorithm
- We keep track of the current sum of the subarray.
- If the sum becomes negative, we reset it to 0 (start a new subarray).
- Track the maximum value the sum ever reached.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/
