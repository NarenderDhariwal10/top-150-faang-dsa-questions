// 🔍 Problem: Partition Equal Subset Sum
// 📝 Link: https://leetcode.com/problems/partition-equal-subset-sum/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Facebook

/*
👨‍💻 Problem Statement:
Given an integer array nums, return true if you can partition the array into two subsets 
such that the sum of the elements in both subsets is equal, or false otherwise.

🧾 Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

🧾 Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

🧾 Example 3:
Input: nums = [2,2,3,5]
Output: false
*/

/*
Constraints:
- 1 <= nums.length <= 200
- 1 <= nums[i] <= 100
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        // If total sum is odd, cannot split equally
        if (total % 2 != 0) return false;

        int target = total / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
/*
🧠 Approach:
- The problem is equivalent to checking if we can find a subset of nums that sums to totalSum / 2.
- Steps:
  1. Compute totalSum of array.
  2. If totalSum is odd → cannot partition → return false.
  3. Target = totalSum / 2.
  4. Use DP to check if subset sum = target exists.
     - dp[i] = whether a subset sum of "i" can be formed.
     - Initialize dp[0] = true.
     - For each num, iterate backwards and update dp.
- If dp[target] is true → partition possible.

🛠️ Time Complexity: O(n * target), where n = number of elements
🛠️ Space Complexity: O(target), optimized from 2D to 1D
✅ Status: Accepted on LeetCode
*/