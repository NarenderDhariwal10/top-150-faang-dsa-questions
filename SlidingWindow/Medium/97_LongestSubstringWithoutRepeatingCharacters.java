// 🔍 Problem: Longest Substring Without Repeating Characters
// 📝 Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Meta, Adobe, Netflix

/*
👨‍💻 Problem Statement:
Given a string `s`, find the length of the longest substring without repeating characters.

🧾 Example 1:
Input: s = "abcabcbb"
Output: 3

🧾 Example 2:
Input: s = "bbbbb"
Output: 1

🧾 Example 3:
Input: s = "pwwkew"
Output: 3

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, maxLen = 0;
        java.util.HashSet<Character> set = new java.util.HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

/*
🧠 Approach:
We use the **Sliding Window** technique with a HashSet to keep track of characters in the current window.
- Expand the right pointer to add new characters.
- If a duplicate character is found, move the left pointer until the duplicate is removed.
- Keep updating the maximum window size.


🛠️ Time Complexity: O(n) — each character is added and removed at most once.
🛠️ Space Complexity: O(min(n, charset_size)) — in worst case, stores all unique chars in set.
✅ Status: Accepted on LeetCode
*/
