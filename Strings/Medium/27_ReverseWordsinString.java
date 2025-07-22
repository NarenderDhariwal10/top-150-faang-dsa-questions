// 🔍 Problem: Reverse Words in a String
// 📝 Link: https://leetcode.com/problems/reverse-words-in-a-string/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Microsoft, Adobe

/*
👨‍💻 Problem Statement:
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters.
The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note: s may contain leading or trailing spaces or multiple spaces between words. 
The returned string should only have a single space separating the words. Do not include any extra spaces.

🧾 Example:
Input: s = "  the sky   is blue  "
Output: "blue is sky the"

Input: s = "  hello world  "
Output: "world hello"

Input: s = "a good   example"
Output: "example good a"
*/

public class Solution {
    public String reverseWords(String s) {
        // Trim leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");
        
        // Reverse the array of words
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }
}

/*
🧠 Approach:
- Use `trim()` to remove leading/trailing whitespace.
- Split the string by one or more spaces using regex `\\s+`.
- Reverse the array of words and join them with a single space.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(n)

✅ Status: Accepted on LeetCode
*/
