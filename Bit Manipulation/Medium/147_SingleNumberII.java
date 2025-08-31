// 🔍 Problem: Single Number II
// 📝 Link: https://leetcode.com/problems/single-number-ii/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Amazon, Facebook, Microsoft

/*
👨‍💻 Problem Statement:
Given an integer array nums where every element appears three times except for one, 
which appears exactly once. Find the single element and return it.

You must implement a solution with O(n) runtime complexity and O(1) extra space.

🧾 Example 1:
Input: nums = [2,2,3,2]
Output: 3

🧾 Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99

*/

class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos; 
            twos = (twos ^ num) & ~ones; 
        }
        return ones; // holds the unique element
    }
}

/*
🧠 Approach:
- Use bit manipulation with two variables (ones, twos) to track bits seen once and twice.
- Logic:
   - ones: holds bits that have appeared 1st time but not 3rd.
   - twos: holds bits that have appeared 2nd time but not 3rd.
   - Whenever a number appears 3 times, both ones and twos reset to 0 for that bit.
- Final answer is stored in ones.

🛠️ Time Complexity: O(n) → one pass through nums
🛠️ Space Complexity: O(1) → constant variables only

✅ Status: Accepted on LeetCode
*/
