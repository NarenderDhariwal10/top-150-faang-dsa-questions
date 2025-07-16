// 🔍 Problem: Contains Duplicate
// 📝 Link: https://leetcode.com/problems/contains-duplicate/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Adobe, Google, Bloomberg

/*
👨‍💻 Problem Statement:
Given an integer array `nums`, return `true` if any value appears at least twice in the array, 
and return `false` if every element is distinct.

🧾 Example:
Input: nums = [1, 2, 3, 1]
Output: true

Input: nums = [1, 2, 3, 4]
Output: false
*/


public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Duplicate found
            }
            seen.add(num); // Add to set
        }

        return false; // No duplicates
    }
}

/*
🧠 Approach:
- Use a HashSet to keep track of elements we've seen.
- If we encounter a duplicate, return true.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(n)

✅ Status: Accepted on LeetCode
*/
