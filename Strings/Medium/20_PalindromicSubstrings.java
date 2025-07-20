// 🔍 Problem: Palindromic Substrings
// 📝 Link: https://leetcode.com/problems/palindromic-substrings/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon,Adobe, Google

/*
👨‍💻 Problem Statement:
Given a string `s`, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is any contiguous sequence of characters within the string.

🧾 Example:
Input: s = "abc"
Output: 3
Explanation: Three palindromic substrings: "a", "b", "c"

Input: s = "aaa"
Output: 6
Explanation: Six palindromic substrings: "a", "a", "a", "aa", "aa", "aaa"
*/

public class Solution {

    public int countSubstrings(String s) {
        int count = 0;

        // Center expansion approach
        for (int i = 0; i < s.length(); i++) {
            count += expandFromCenter(s, i, i);     // Count odd-length palindromes
            count += expandFromCenter(s, i, i + 1); // Count even-length palindromes
        }

        return count;
    }

    private int expandFromCenter(String s, int left, int right) {
        int count = 0;

        // Expand while palindrome is valid
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}

/*
🧠 Approach:
- For each character, try expanding around it as a center (both odd and even cases).
- Count each valid expansion as a palindromic substring.

🛠️ Time Complexity: O(n^2)
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/
