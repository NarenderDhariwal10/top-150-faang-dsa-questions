// 🔍 Problem: Subarray Sum Equals K
// 📝 Link: https://leetcode.com/problems/subarray-sum-equals-k/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Facebook, Google

/*
👨‍💻 Problem Statement:
Given an array of integers `nums` and an integer `k`,
return the total number of continuous subarrays whose sum equals to `k`.

🧾 Example:
Input: nums = [1, 1, 1], k = 2
Output: 2

Input: nums = [1, 2, 3], k = 3
Output: 2
*/

import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        // Map to store (prefix sum) -> number of times it appears
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // For subarrays that start from index 0

        int count = 0;
        int sum = 0;

        // Loop through the array
        for (int num : nums) {
            sum += num;

            // If (sum - k) exists in map, it means we found a subarray
            if (prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k);
            }

            // Add the current sum to the map
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

/*
🧠 Approach:
- Use a HashMap to store the prefix sum up to each index.
- At each step, check if (current sum - k) exists in the map.
- This means a subarray with sum == k ends at current index.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(n)

✅ Status: Accepted on LeetCode
*/
