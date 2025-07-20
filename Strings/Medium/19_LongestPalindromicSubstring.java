// 🔍 Problem: Longest Palindromic Substring
// 📝 Link: https://leetcode.com/problems/longest-palindromic-substring/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Microsoft, Adobe

/*
👨‍💻 Problem Statement:
Given a string `s`, return the longest palindromic substring in `s`.

🧾 Example :
Input: s = "babad"
Output: "bab"
(Note: "aba" is also a valid answer)

Input: s = "cbbd"
Output: "bb"
*/

public class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);       // For odd-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1);   // For even-length palindromes
            int len = Math.max(len1, len2);

            // If found a longer palindrome
            if (len > end - start) {
                start = i - (len - 1) / 2;  // update start index
                end = i + len / 2;         // update end index
            }
        }

        return s.substring(start, end + 1);
    }

    // Helper function to expand from the center
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;   // move left pointer to left
            right++;  // move right pointer to right
        }

        return right - left - 1; // length of palindrome
    }
}

/*
🧠 Approach:
- Try to expand around every character (odd and even length centers).
- For each expansion, update the longest palindrome if needed.

🛠️ Time Complexity: O(n^2) — because for each character, we may expand up to the full string.
🛠️ Space Complexity: O(1) — only a few integer variables are used.

✅ Status: Accepted on LeetCode
*/
