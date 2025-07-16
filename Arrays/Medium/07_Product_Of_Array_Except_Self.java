// 🔍 Problem: Product of Array Except Self
// 📝 Link: https://leetcode.com/problems/product-of-array-except-self/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Facebook, Microsoft

/*
👨‍💻 Problem Statement:
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to 
the product of all the elements of `nums` except `nums[i]`.

You must write an algorithm that runs in O(n) time and without using division.

🧾 Example:
Input:  nums = [1,2,3,4]
Output: [24,12,8,6]
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Step 1: Calculate prefix products (left to right)
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply with suffix products (right to left)
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right *= nums[i];
        }

        return res;
    }
}

/*
🧠 Approach:
- First pass calculates prefix product for each index (left of i).
- Second pass multiplies result with suffix product (right of i).
- No division is used.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(1) extra space (output array excluded)

✅ Status: Accepted on LeetCode
*/
