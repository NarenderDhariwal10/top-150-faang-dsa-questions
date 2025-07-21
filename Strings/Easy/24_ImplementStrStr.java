// 🔍 Problem: Implement strStr()
// 📝 Link: https://leetcode.com/problems/implement-strstr/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Meta, Google

/*
👨‍💻 Problem Statement:
Implement `strStr()`. Given two strings `haystack` and `needle`, return the index of the 
first occurrence of `needle` in `haystack`, or -1 if `needle` is not part of `haystack`.

🧾 Example:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0

Input: haystack = "leetcode", needle = "leeto"
Output: -1
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (n == 0) return 0; // edge case: empty needle

        for (int i = 0; i <= m - n; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }

        return -1; // needle not found
    }
}

/*
🧠 Approach:
- Use a sliding window of size equal to the length of `needle` and check each substring in `haystack`.
- Return the starting index when a match is found.
- If no match is found after scanning, return -1.

🛠️ Time Complexity: O(m * n) in worst case (brute-force check)
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/
