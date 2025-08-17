// 🔍 Problem: Reorganize String
// 📝 Link: https://leetcode.com/problems/reorganize-string/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Amazon, Google, Facebook, Microsoft

/*
📝 Problem Statement:
   Given a string s, rearrange the characters of s so that no two adjacent 
   characters are the same. Return any possible rearrangement, or return "" 
   if not possible.

   🧾 Example 1:
   Input: s = "aab"
   Output: "aba"

   🧾 Example 2:
   Input: s = "aaab"
   Output: ""a
*/

import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        // Count frequency of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Max Heap based on character frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();
        int[] prev = {-1, 0}; // {charIndex, count}

        // Greedily arrange characters
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            result.append((char)(current[0] + 'a'));
            current[1]--;

            if (prev[1] > 0) {
                pq.offer(prev);
            }
            prev = current;
        }

        return result.length() == s.length() ? result.toString() : "";
    }
}

/*
🧠 Approach (Greedy + Heap):
   - Count frequencies of all characters.
   - Use a max-heap to always pick the most frequent character that is not the same as the previous one.
   - Keep track of the previous character and push it back once its turn is valid.
   - If the final string length != original string length, return "" (not possible).

🛠️ Time Complexity: O(n log 26) ≈ O(n)
🛠️ Space Complexity: O(26) ≈ O(1)
✅ Status: Accepted on LeetCode
*/
