// 🔍 Problem: Two Sum
// 📝 Link: https://leetcode.com/problems/two-sum/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Google, Adobe, Microsoft

/*
👨‍💻 Problem Statement:
Given an array of integers `nums` and an integer `target`, return indices of the two numbers
such that they add up to `target`.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example:
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Explanation: nums[0] + nums[1] == 9, so we return [0, 1]
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Brute force approach: Try every pair (i, j) where i < j and check if nums[i] + nums[j] == target
        for (int i = 0; i < nums.length - 1; i++) {
            int complement = target - nums[i]; // value we need to find
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == complement) {
                    // If nums[i] + nums[j] == target, return their indices
                    return new int[] { i, j };
                }
            }
        }

        // If no solution found (according to constraints, this should never happen)
        throw new IllegalArgumentException("No two sum solution exists");
    }
}

/*
🧠 Approach:
- Check every pair of elements in the array.
- If their sum is equal to the target, return their indices.

🛠️ Time Complexity: O(n^2)
- We check every possible pair.

🛠️ Space Complexity: O(1)
- We are not using any extra space, only primitive variables.

✅ Status: Accepted on LeetCode
*/
