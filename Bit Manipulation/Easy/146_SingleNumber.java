// 🔍 Problem: Single Number
// 📝 Link: https://leetcode.com/problems/single-number/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Microsoft, Apple, Google, Facebook

/*
👨‍💻 Problem Statement:
Given a non-empty array of integers nums, every element appears twice except for one. 
Find that single one.

You must implement a solution with O(n) runtime complexity and only O(1) extra space.

🧾 Example 1:
Input: nums = [2,2,1]
Output: 1

🧾 Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

🧾 Example 3:
Input: nums = [1]
Output: 1

*/

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR cancels out duplicate numbers
        }
        return result;
    }
}

/*
🧠 Approach:
- Use the properties of XOR:
   - x ^ x = 0  (same numbers cancel out)
   - x ^ 0 = x
   - XOR is commutative & associative → order doesn’t matter
- Iterate through nums, XOR all elements.
- Since pairs cancel out, only the single element remains.

🛠️ Time Complexity: O(n) → one pass through the array
🛠️ Space Complexity: O(1) → no extra memory used

✅ Status: Accepted on LeetCode
*/
