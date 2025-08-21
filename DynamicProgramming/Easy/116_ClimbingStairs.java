// 🔍 Problem: Climbing Stairs
// 📝 Link: https://leetcode.com/problems/climbing-stairs/
// 🎯 Difficulty: Easy
// 🏢 Asked In: Amazon, Microsoft, Apple, Google

/*
📝 Problem Statement:
You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb **1** or **2** steps.  
In how many distinct ways can you climb to the top?

-
🧾 Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

🧾 Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n; // base cases

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // recurrence relation
        }

        return dp[n];
    }
}

/*
🧠 Approach:
1. Recognize that this is a Fibonacci-like problem:
   - To reach step `i`, you can come from step `i-1` or step `i-2`.
   - Hence: dp[i] = dp[i-1] + dp[i-2]
2. Initialize base cases:
   - dp[1] = 1
   - dp[2] = 2
3. Iteratively fill dp array until `n`.

--------------------------------------------------
🛠️ Time Complexity: O(n) → loop through all steps
🛠️ Space Complexity: O(n) → dp array used
   (Can be optimized to O(1) using two variables)

✅ Status: Accepted on LeetCode
*/
