// 🔍 Problem: Coin Change
// 📝 Link: https://leetcode.com/problems/coin-change/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Facebook, Apple

/*
👨‍💻 Problem Statement:
You are given an integer array coins representing coins of different denominations 
and an integer amount representing a total amount of money. 

Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.
*/

/*
🧾 Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

🧾 Example 2:
Input: coins = [2], amount = 3
Output: -1

🧾 Example 3:
Input: coins = [1], amount = 0
Output: 0

🧾 Example 4:
Input: coins = [1], amount = 2
Output: 2
*/

/*
Constraints:
- 1 <= coins.length <= 12
- 1 <= coins[i] <= 2^31 - 1
- 0 <= amount <= 10^4
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; // large value to represent infinity
        int[] dp = new int[amount + 1];
        
        // Initialize dp with a large value
        for (int i = 1; i <= amount; i++) {
            dp[i] = max;
        }
        dp[0] = 0; // Base case: 0 coins needed to make 0
        
        // Build the DP array
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

/*
🧠 Approach:
- Classic DP problem similar to "Unbounded Knapsack".
- Define dp[i] = minimum number of coins required to make amount i.
- Initialize dp[0] = 0 and all others with infinity (or amount+1).
- For each coin:
    - For each i from coin to amount:
        dp[i] = min(dp[i], dp[i - coin] + 1)
- Answer is dp[amount]. If dp[amount] > amount, return -1.

🛠️ Time Complexity: O(n * amount), where n = number of coins
🛠️ Space Complexity: O(amount)
✅ Status: Accepted on LeetCode
*/
