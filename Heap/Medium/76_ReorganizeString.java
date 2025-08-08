// 🔍 Problem: Reorganize String
// 📝 Link: https://leetcode.com/problems/reorganize-string/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Microsoft, Adobe

/*
👨‍💻 Problem Statement:
Given a string s, rearrange the characters of s so that no two adjacent characters are the same.
Return any possible rearrangement of s or return "" if not possible.

🧾 Example:
Input: s = "aab"
Output: "aba"

Input: s = "aaab"
Output: ""

*/

class Solution {
    public String reorganizeString(String s) {
        // Step 1: Count frequency of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Add to max heap based on character frequency
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.add(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();
        int[] prev = {-1, 0}; // Store the last used character

        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll(); // [charIndex, count]
            result.append((char)(current[0] + 'a'));

            // If previous still has count left, push it back to heap
            if (prev[1] > 0) {
                maxHeap.add(prev);
            }

            current[1]--;
            prev = current; // update previous
        }

        // Check if valid
        return result.length() == s.length() ? result.toString() : "";
    }
}

/*
🧠 Approach:
- Count character frequencies.
- Use a max heap to always place the most frequent character.
- Greedily build the result string ensuring no adjacent characters are the same.
- Maintain the previously placed character and push it back to the heap only after using another one.

🛠️ Time Complexity: O(n log k), where k is the number of unique characters (max 26)
🛠️ Space Complexity: O(n + k)

✅ Status: Accepted on LeetCode
*/
