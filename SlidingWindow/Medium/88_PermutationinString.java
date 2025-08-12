// 🔍 Problem: Permutation in String
// 📝 Link: https://leetcode.com/problems/permutation-in-string/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Microsoft, Amazon

/*
👨‍💻 Problem Statement:
Given two strings `s1` and `s2`, return true if `s2` contains a permutation of `s1`,
or false otherwise.

In other words, return true if one of `s1`'s permutations is the substring of `s2`.

🧾 Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

🧾 Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Count frequency of chars in s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        // Sliding window over s2
        for (int i = 0; i < s2.length(); i++) {
            s2Count[s2.charAt(i) - 'a']++;

            // Keep window size same as s1 length
            if (i >= s1.length()) {
                s2Count[s2.charAt(i - s1.length()) - 'a']--;
            }

            // Compare both frequency arrays
            if (matches(s1Count, s2Count)) return true;
        }

        return false;
    }

    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }
        return true;
    }
}

/*
🧠 Approach:
- Use two frequency arrays of size 26 (for lowercase letters).
- First, store char counts of `s1`.
- Slide a window of length `s1.length()` over `s2` and update counts.
- Compare counts at each step to check if window matches s1's permutation.

🛠️ Time Complexity: O(n) – n = length of s2 (constant array compare takes O(26) = O(1))
🛠️ Space Complexity: O(1) – fixed size arrays
✅ Status: Ready to push — file name: 567_PermutationInString.java
*/
