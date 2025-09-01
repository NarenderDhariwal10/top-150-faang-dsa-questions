// 🔍 Problem: Counting Bits
// 📝 Link: https://leetcode.com/problems/counting-bits/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Google, Facebook, Amazon, Microsoft

/*
👨‍💻 Problem Statement:
Given an integer n, return an array ans of length n + 1 such that 
for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

🧾 Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

🧾 Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
*/

class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1); 
            // i >> 1 → right shift (divide by 2)
            // i & 1 → check if last bit is set
        }
        return dp;
    }
}

/*
🧠 Approach:
- Use dynamic programming with bit manipulation.
- Observation:
   - dp[i] = dp[i >> 1] + (i & 1)
   - Because:
     - Shifting right by 1 removes the last bit.
     - (i & 1) adds 1 if the last bit is set.
- This builds up results efficiently from 0 → n.

🛠️ Time Complexity: O(n) → loop from 1 to n
🛠️ Space Complexity: O(n) → output array of size n+1

✅ Status: Accepted on LeetCode
*/
