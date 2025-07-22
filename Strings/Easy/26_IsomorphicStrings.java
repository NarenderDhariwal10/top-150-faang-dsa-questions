// 🔍 Problem: Isomorphic Strings
// 📝 Link: https://leetcode.com/problems/isomorphic-strings/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Adobe, Google

/*
👨‍💻 Problem Statement:
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.

🧾 Example:
Input: s = "egg", t = "add"
Output: true

Input: s = "foo", t = "bar"
Output: false

Input: s = "paper", t = "title"
Output: true
*/

import java.util.*;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> mapped = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (map.containsKey(ch1)) {
                if (map.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if (mapped.contains(ch2)) return false;

                map.put(ch1, ch2);
                mapped.add(ch2);
            }
        }

        return true;
    }
}

/*
🧠 Approach:
- Use a HashMap to store character mappings from string s to string t.
- Use a HashSet to keep track of characters in t that are already mapped.
- Traverse each character and check for consistency in mapping.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(n)

✅ Status: Accepted on LeetCode
*/
