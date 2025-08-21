// 🔍 Problem: Palindrome Partitioning
// 📝 Link: https://leetcode.com/problems/palindrome-partitioning/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Amazon, Microsoft, Google, Bloomberg

/*
📝 Problem Statement:
Given a string `s`, partition `s` such that every substring of the partition is a palindrome. 
Return all possible palindrome partitioning of `s`.

-
🧾 Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

🧾 Example 2:
Input: s = "a"
Output: [["a"]]
*/

import java.util.*;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String substring = s.substring(start, end + 1);
            if (isPalindrome(substring)) {
                current.add(substring);
                backtrack(s, end + 1, current, result);
                current.remove(current.size() - 1); // backtrack
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

/*
🧠 Approach:
1. Use **Backtracking** to explore all partitions.
2. Start from index `0` and try every possible substring.
3. If a substring is a **palindrome**, include it in the current partition and recurse.
4. When the start index reaches the end of the string → add the partition to the result.
5. Backtrack to explore other partitions.

--------------------------------------------------
🛠️ Time Complexity: O(N * 2^N) → Each index can split or not, and palindrome check costs O(N).
🛠️ Space Complexity: O(N) → recursion depth and substring storage.

✅ Status: Accepted on LeetCode
*/
