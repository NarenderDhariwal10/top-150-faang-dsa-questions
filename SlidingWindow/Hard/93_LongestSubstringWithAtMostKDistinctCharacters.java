// 🔍 Problem: Longest Substring with At Most K Distinct Characters
// 📝 Link: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Facebook, Microsoft

/*
👨‍💻 Problem Statement:
Given a string `s` and an integer `k`, return the length of the longest substring 
that contains at most `k` distinct characters.

🧾 Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.

🧾 Example 2:
Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
*/

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

/*
🧠 Approach:
- Use a sliding window with a HashMap to store character frequencies.
- Expand the window by moving the right pointer and shrink it from the left 
  whenever the number of distinct characters exceeds `k`.
- Keep track of the maximum length of valid windows.

🛠️ Time Complexity: O(n) – each character is processed at most twice.
🛠️ Space Complexity: O(k) – storing at most `k` distinct characters in the map.
✅ Status: Ready to push — file name: 340_LongestSubstringWithAtMostKDistinctCharacters.java
*/
