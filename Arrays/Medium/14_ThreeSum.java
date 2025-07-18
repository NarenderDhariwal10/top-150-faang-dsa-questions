// 🔍 Problem: 3Sum
// 📝 Link: https://leetcode.com/problems/3sum/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Facebook, Microsoft, Adobe

/*
👨‍💻 Problem Statement:
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i ≠ j, i ≠ k, and j ≠ k, and nums[i] + nums[j] + nums[k] == 0.

Note: The solution set must not contain duplicate triplets.

🧾 Example:
Input: nums = [-1, 0, 1, 2, -1, -4]
Output: [[-1, -1, 2], [-1, 0, 1]]

Input: nums = [0, 1, 1]
Output: []

Input: nums = [0, 0, 0]
Output: [[0, 0, 0]]
*/

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to use two pointers

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            // Two-pointer approach
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Need a larger number
                } else {
                    right--; // Need a smaller number
                }
            }
        }

        return result;
    }
}

/*
🧠 Approach:
- Sort the array to simplify finding triplets.
- Use a for-loop with two pointers (left and right) to find all unique triplets.
- Skip duplicate elements to avoid duplicate triplets.

🛠️ Time Complexity: O(n^2)
🛠️ Space Complexity: O(1) (excluding output list)

✅ Status: Accepted on LeetCode
*/
