// 🔍 Problem: Minimum Window Substring
// 📝 Link: https://leetcode.com/problems/minimum-window-substring/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Amazon, Microsoft, Facebook, Google

/*
👨‍💻 Problem Statement:
Given two strings `s` and `t` of lengths `m` and `n` respectively, return the minimum window 
substring of `s` such that every character in `t` (including duplicates) is included in the window. 
If there is no such substring, return the empty string "".

The test cases will be generated such that the answer is unique.

🧾 Example:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

Input: s = "a", t = "a"
Output: "a"

Input: s = "a", t = "aa"
Output: ""

*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0, start = 0, minLen = Integer.MAX_VALUE;
        int matchCount = 0;

        Map<Character, Integer> window = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                matchCount++;
            }

            while (matchCount == need.size()) {
                if (right - left + 1 < minLen) {
                    start = left;
                    minLen = right - left + 1;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    matchCount--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}

/*
🧠 Approach:
- Use the sliding window technique with two pointers.
- Count characters in `t` using a hashmap.
- Expand the right pointer to include valid characters.
- Once all characters from `t` are matched, shrink the window from the left to find the smallest valid window.

🛠️ Time Complexity: O(s.length + t.length)
🛠️ Space Complexity: O(1) (since the character set is fixed to ASCII)

✅ Status: Accepted on LeetCode
*/
