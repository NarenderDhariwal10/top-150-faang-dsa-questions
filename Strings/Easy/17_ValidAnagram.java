// 🔍 Problem: Valid Anagram  
// 📝 Link: https://leetcode.com/problems/valid-anagram/  
// 🎯 Difficulty: Easy  
// 🏢 Asked in: Amazon, PayPal, Microsoft 

/*
👨‍💻 Problem Statement:
Given two strings `s` and `t`, return true if `t` is an anagram of `s`, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase.

🧾 Example:
Input: s = "anagram", t = "nagaram"  
Output: true  

Input: s = "rat", t = "car"  
Output: false
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // For lowercase English letters

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // Increment count for s
            count[t.charAt(i) - 'a']--; // Decrement count for t
        }

        for (int val : count) {
            if (val != 0) return false; // If mismatch, not anagram
        }

        return true;
    }
}

/*
🧠 Approach:
- Count characters from both strings using an array of size 26.
- If frequencies match, the strings are anagrams.

🛠️ Time Complexity: O(n)  
🛠️ Space Complexity: O(1) — fixed array size (26)

✅ Status: Accepted on LeetCode
*/
