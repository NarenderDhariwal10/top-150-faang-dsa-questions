// 🔍 Problem: Longest Substring Without Repeating Characters  
// 📝 Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/  
// 🎯 Difficulty: Medium  
// 🏢 Asked in: Google, Microsoft

/*
👨‍💻 Problem Statement:
Given a string `s`, find the length of the longest substring without repeating characters.

🧾 Example:
Input: s = "abcabcbb"
Output: 3  
Explanation: The answer is "abc", with the length of 3.

Input: s = "bbbbb"
Output: 1  
Explanation: The answer is "b", with the length of 1.
*/

import java.util.HashMap;
import java.util.Map;

public class Solution{
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If duplicate found and it's within current window
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;  // Move left pointer to exclude duplicate
            }

            map.put(ch, right);  // Store/update character index
            maxLen = Math.max(maxLen, right - left + 1);  // Update max length
        }

        return maxLen;
    }
}

/*
🧠 Approach:
- Use Sliding Window with a HashMap to track character positions.
- Move the left pointer when a duplicate is found within the current window.

🛠️ Time Complexity: O(n)  
🛠️ Space Complexity: O(n)

✅ Status: Accepted on LeetCode
*/
