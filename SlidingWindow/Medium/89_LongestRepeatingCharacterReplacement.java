// 🔍 Problem: Longest Repeating Character Replacement
// 📝 Link: https://leetcode.com/problems/longest-repeating-character-replacement/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Meta, Facebook, Amazon, Microsoft

/*
👨‍💻 Problem Statement:
You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character.
You can perform this operation at most `k` times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

🧾 Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with 'B's to get "BBBB".

🧾 Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' with 'B' to get "AABBBBA".
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxCount = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // If window size minus most frequent char count > k, shrink window
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

/*
🧠 Approach:
- Use sliding window with two pointers.
- Track the frequency of each character in the window.
- Keep track of the count of the most frequent character in the current window.
- If `(window size - max frequency) > k`, shrink the window from the left.
- Update the maximum length found.

🛠️ Time Complexity: O(n) – each char is processed at most twice.
🛠️ Space Complexity: O(1) – fixed array of size 26.
✅ Status: Ready to push — file name: 424_LongestRepeatingCharacterReplacement.java
*/
