// 🔍 Problem: Maximum Product Subarray
// 📝 Link: https://leetcode.com/problems/maximum-product-subarray/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Adobe, Google, Microsoft

/*
👨‍💻 Problem Statement:
Given an integer array `nums`, find the contiguous subarray (containing at least one number)
which has the largest product, and return the product.

🧾 Example:
Input: nums = [2, 3, -2, 4]
Output: 6

Input: nums = [-2, 0, -1]
Output: 0
Explanation: The result cannot be 2, because [-2, -1] is not a contiguous subarray.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxProduct = nums[0];      // Final result
        int currMax = nums[0];         // Max product ending at current index
        int currMin = nums[0];         // Min product ending at current index (important for negatives)

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // If the current element is negative, swap max and min
            if (current < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            // Update current max and min
            currMax = Math.max(current, currMax * current);
            currMin = Math.min(current, currMin * current);

            // Update overall max product
            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
    }
}

/*
🧠 Approach:
- Keep track of both the maximum and minimum product at each step (because a negative number can flip the sign).
- Swap max/min when the current number is negative.
- Use Kadane-like traversal but for product.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/
