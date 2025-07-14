// 🔍 Problem: Majority Element
// 📝 Link: https://leetcode.com/problems/majority-element/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Adobe, Amazon, Microsoft, Goldman Sachs

/*
👨‍💻 Problem Statement:
Given an array `nums` of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

🧾 Example:
Input: nums = [3, 2, 3]
Output: 3
*/

public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                // Choose new candidate when count drops to zero
                candidate = num;
            }
            // Increment or decrement count
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}

/*
🧠 Approach: Moore’s Voting Algorithm
- The idea is to cancel out each occurrence of an element `e` with all the other elements that are different from `e`.
- In the end, the element remaining is the majority element.

🛠️ Time Complexity: O(n)
- Single pass through the array

🛠️ Space Complexity: O(1)
- Constant extra space

✅ Status: Accepted on LeetCode
*/
