// 🔍 Problem: Longest Common Prefix
// 📝 Link: https://leetcode.com/problems/longest-common-prefix/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Google, Microsoft, Apple

/*
👨‍💻 Problem Statement:
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

🧾 Example:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Input: strs = ["dog","racecar","car"]
Output: ""

Explanation: There is no common prefix among the input strings.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Start with the prefix as the first word
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix until it matches the beginning of the current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}

/*
🧠 Approach:
- Assume the first string is the prefix.
- Iterate through other strings and reduce the prefix until it matches the beginning of each string.

🛠️ Time Complexity: O(n * m), where n = number of strings, m = length of the shortest string
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/
