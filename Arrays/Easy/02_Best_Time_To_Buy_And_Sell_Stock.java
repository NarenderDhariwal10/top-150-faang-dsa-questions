// 🔍 Problem: Best Time to Buy and Sell Stock
// 📝 Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Apple, Amazon, Google, Microsoft

/*
👨‍💻 Problem Statement:
You are given an array `prices` where `prices[i]` is the price of a given stock on the i-th day.

You want to maximize your profit by choosing a **single day to buy one stock** and choosing a **different day in the future to sell** that stock.

Return the maximum profit you can achieve from this transaction. If no profit is possible, return 0.

🧾 Example:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = Integer.MAX_VALUE; // Minimum stock price seen so far
        int maxProfit = 0;                // Maximum profit achievable

        // Traverse the price array once
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // Update the lowest price to buy
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                // Update the max profit if current price - minPrice is better
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}

/*
🧠 Approach:
- Keep track of the minimum price so far.
- At each step, calculate potential profit = current price - minPrice.
- Update maxProfit if this profit is higher than before.

🛠️ Time Complexity: O(n)
- We traverse the array only once.

🛠️ Space Complexity: O(1)
- We use only constant extra variables.

✅ Status: Accepted on LeetCode
*/
