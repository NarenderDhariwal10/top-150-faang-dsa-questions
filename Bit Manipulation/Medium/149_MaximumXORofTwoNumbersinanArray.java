// 🔍 Problem: Maximum XOR of Two Numbers in an Array
// 📝 Link: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Google, Amazon, Facebook, Microsoft, Apple

/*
👨‍💻 Problem Statement:
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], 
where 0 <= i <= j < n.

🧾 Example 1:
Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 ^ 25 = 28.

🧾 Example 2:
Input: nums = [0]
Output: 0

🧾 Example 3:
Input: nums = [2,4]
Output: 6
*/

class TrieNode {
    TrieNode[] children = new TrieNode[2]; // only 0 or 1 bits
}

class Solution {
    private TrieNode root = new TrieNode();

    // Insert number into the Trie
    private void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) { // traverse 32 bits
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    // Find maximum XOR for a given number
    private int findMaxXOR(int num) {
        TrieNode node = root;
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int oppositeBit = 1 - bit;
            if (node.children[oppositeBit] != null) {
                xor |= (1 << i); // maximize XOR
                node = node.children[oppositeBit];
            } else {
                node = node.children[bit];
            }
        }
        return xor;
    }

    public int findMaximumXOR(int[] nums) {
        // Step 1: Build Trie
        for (int num : nums) {
            insert(num);
        }
        // Step 2: For each number, find best XOR
        int maxXor = 0;
        for (int num : nums) {
            maxXor = Math.max(maxXor, findMaxXOR(num));
        }
        return maxXor;
    }
}

/*
🧠 Approach:
- Use a Trie of bits (0/1) to store binary representation of numbers.
- For each number, try to go opposite bit in Trie (to maximize XOR).
   - If bit = 1 → prefer 0
   - If bit = 0 → prefer 1
- Build Trie in O(N * 32), query in O(N * 32).

🛠️ Time Complexity:
- Build Trie: O(N * 32)
- Find XOR: O(N * 32)
- Total: O(N * 32) ≈ O(N)

🛠️ Space Complexity: O(N * 32) for Trie nodes

✅ Status: Accepted on LeetCode
*/
