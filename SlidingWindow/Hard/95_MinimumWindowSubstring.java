// 🔍 Problem: Minimum Window Substring
// 📝 Link: https://leetcode.com/problems/minimum-window-substring/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Amazon, Microsoft, Google, Facebook

/*
👨‍💻 Problem Statement:
Given two strings `s` and `t` of lengths m and n respectively, return the minimum window substring of `s`
such that every character in `t` (including duplicates) is included in the window. 
If there is no such substring, return the empty string "".

🧾 Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

🧾 Example 2:
Input: s = "a", t = "a"
Output: "a"

🧾 Example 3:
Input: s = "a", t = "aa"
Output: ""
*/

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] tFreq = new int[128];
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start = 0;
        int required = t.length();
        int[] windowFreq = new int[128];

        while (right < s.length()) {
            char rc = s.charAt(right);
            if (tFreq[rc] > 0) {
                if (windowFreq[rc] < tFreq[rc]) {
                    required--;
                }
            }
            windowFreq[rc]++;
            right++;

            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lc = s.charAt(left);
                windowFreq[lc]--;
                if (tFreq[lc] > 0 && windowFreq[lc] < tFreq[lc]) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}

/*
🧠 Approach:
- Maintain two frequency arrays: one for `t` and one for the current window in `s`.
- Expand `right` pointer to include characters and reduce `required` when a needed char is found.
- When all characters are matched (`required == 0`), shrink the window from `left` to find the smallest valid window.
- Keep track of the smallest window found.

🛠️ Time Complexity: O(m + n) – m = s.length, n = t.length.
🛠️ Space Complexity: O(1) – only fixed-size arrays of length 128 are used.
✅ Status: Ready to push — file name: 76_MinimumWindowSubstring.java
*/
