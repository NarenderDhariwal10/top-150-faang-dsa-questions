// 🔍 Problem: Letter Combinations of a Phone Number
// 📝 Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Amazon, Meta, Google, Facebook

/*
📝 Problem Statement:
Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
that the number could represent. Return the answer in any order.

The mapping of digit to letters (just like on telephone buttons) is given below:
2 -> "abc", 3 -> "def", 4 -> "ghi", 5 -> "jkl"
6 -> "mno", 7 -> "pqrs", 8 -> "tuv", 9 -> "wxyz"

⚠️ Note:
- Digits 0 and 1 do not map to any letters.

-
🧾 Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

🧾 Example 2:
Input: digits = ""
Output: []

🧾 Example 3:
Input: digits = "2"
Output: ["a","b","c"]
*/

import java.util.*;

public class Solution {
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}

/*
🧠 Approach:
1. Use a mapping of digits → characters (like old phone keypad).
2. Apply **backtracking**:
   - If current string length == digits length → add to result.
   - Else → for each character mapped from current digit:
       - Append character, recurse for next digit.
       - Backtrack by removing last added character.
3. Continue until all combinations are explored.

--------------------------------------------------
🛠️ Time Complexity: O(4^N) → N is length of digits (max 4 choices per digit).
🛠️ Space Complexity: O(N) → recursion depth + StringBuilder.

✅ Status: Accepted on LeetCode
*/
