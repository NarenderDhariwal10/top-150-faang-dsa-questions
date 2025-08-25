// 🔍 Problem: Maximum Product Subarray
// 📝 Link: https://leetcode.com/problems/maximum-product-subarray/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Adobe, Facebook

/*
👨‍💻 Problem Statement:
Given an integer array nums, find a contiguous non-empty subarray within the array 
that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

🧾 Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product = 6.

🧾 Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a contiguous subarray.

🧾 Example 3:
Input: nums = [-2,3,-4]
Output: 24
Explanation: Subarray [ -2, 3, -4 ] has the largest product = 24.
*/

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        // Initialize DP states
        int maxSoFar = nums[0];
        int minSoFar = nums[0]; 
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            int current = nums[i];

            // Since multiplying by a negative number can flip min ↔ max
            int tempMax = Math.max(current, Math.max(maxSoFar * current, minSoFar * current));
            int tempMin = Math.min(current, Math.min(maxSoFar * current, minSoFar * current));

            maxSoFar = tempMax;
            minSoFar = tempMin;

            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}

/*
🧠 Approach (Dynamic Programming with State Tracking):
- Key observation: A negative number flips max ↔ min.
- Maintain two states at each index:
  1. maxSoFar = maximum product ending at index i
  2. minSoFar = minimum product ending at index i
- At each step:
  - tempMax = max(current, maxSoFar * current, minSoFar * current)
  - tempMin = min(current, maxSoFar * current, minSoFar * current)
- Update result = max(result, maxSoFar)

🛠️ Time Complexity: O(n)  
🛠️ Space Complexity: O(1) (only storing current max & min)  
✅ Status: Accepted on LeetCode
*/
