// 🔍 Problem: Best Time to Buy and Sell Stock
// 📝 Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// 🎯 Difficulty: Easy
// 🏢 Asked in: Amazon, Microsoft, Google, Facebook, Apple

/*
👨‍💻 Problem Statement:
You are given an array `prices` where prices[i] is the price of a given stock on the iᵗʰ day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell it.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

🧾 Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5.

🧾 Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: No transaction is done, profit = 0.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update buying price
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // Update profit
            }
        }

        return maxProfit;
    }
}

/*
🧠 Approach:
- Keep track of the minimum price seen so far while iterating through the array.
- For each price, calculate potential profit if sold today and update the max profit.
- This effectively uses a sliding window idea where the left boundary is the minimum price so far.

🛠️ Time Complexity: O(n) – iterate through prices once.
🛠️ Space Complexity: O(1) – constant extra space.
✅ Status: Ready to push — file name: 121_BestTimeToBuyAndSellStock.java
*/
