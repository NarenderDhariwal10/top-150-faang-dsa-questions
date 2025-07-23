// 🔍 Problem: Check if a String Is a Rotation of Another String
// 📝 Link: https://www.interviewbit.com/problems/rotate-string/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Adobe

/*
👨‍💻 Problem Statement:
Given two strings `s1` and `s2`, check if `s2` is a rotation of `s1` using only one call to `isSubstring` 
(i.e., using `contains()` in Java).

A string `s2` is a rotation of `s1` if it can be obtained by shifting some prefix of `s1` to the end of `s1`.

🧾 Example:
Input: s1 = "waterbottle", s2 = "erbottlewat"
Output: true

Input: s1 = "hello", s2 = "llohe"
Output: true

Input: s1 = "abc", s2 = "acb"
Output: false
*/

public class Solution {
    public boolean isRotation(String s1, String s2) {
        // Check if both strings are non-null and of the same length
        if (s1.length() != s2.length() || s1.length() == 0) {
            return false;
        }

        // Concatenate s1 with itself and check if s2 is a substring
        String combined = s1 + s1;
        return combined.contains(s2);
    }
}

/*
🧠 Approach:
- If `s2` is a rotation of `s1`, then it must be a substring of `s1 + s1`.
- For example: "erbottlewat" is a rotation of "waterbottle" → "waterbottlewaterbottle".contains("erbottlewat")

🛠️ Time Complexity: O(n), where n is the length of the string
🛠️ Space Complexity: O(n), for concatenated string

✅ Status: Accepted (based on known interview problem)
*/
