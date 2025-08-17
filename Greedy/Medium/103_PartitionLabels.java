// 🔍 Problem: Partition Labels
// 📝 Link: https://leetcode.com/problems/partition-labels/
// 🎯 Difficulty: Medium
// 🏢 Asked In: Amazon, Facebook, Google, Microsoft

/*
📝 Problem Statement:
   You are given a string s. We want to partition the string into as many parts as possible
   so that each letter appears in at most one part, and return a list of integers 
   representing the size of these parts.

   🧾 Example 1:
   Input: s = "ababcbacadefegdehijhklij"
   Output: [9,7,8]

   🧾 Example 2:
   Input: s = "eccbbbbdec"
   Output: [10]
*/

import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        // Store the last index of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;

        // Traverse string and find partitions
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}

/*
🧠 Approach (Greedy):
   - Precompute the last occurrence of each character in the string.
   - Iterate through the string, expanding the current partition to include the farthest last occurrence seen so far.
   - When the current index matches the farthest last occurrence, close the partition.

🛠️ Time Complexity: O(n) (one pass to fill lastIndex + one pass to partition)
🛠️ Space Complexity: O(1) (fixed 26 array)
✅ Status: Accepted on LeetCode
*/
