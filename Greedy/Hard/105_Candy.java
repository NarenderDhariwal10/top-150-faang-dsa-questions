// 🔍 Problem: Candy
// 📝 Link: https://leetcode.com/problems/candy/
// 🎯 Difficulty: Hard
// 🏢 Asked In: Google, Amazon, Microsoft, Apple

/*
📝 Problem Statement:
    There are n children standing in a line. Each child is assigned a rating value 
    given in the integer array ratings.

    You are giving candies to these children subjected to the following requirements:
    1. Each child must have at least one candy.
    2. Children with a higher rating get more candies than their neighbors.

    Return the minimum number of candies you need to distribute.

    🧾 Example 1:
    Input: ratings = [1,0,2]
    Output: 5
    Explanation: You can allocate to the first, second and third child with 
    2, 1, 2 candies respectively.

    🧾 Example 2:
    Input: ratings = [1,2,2]
    Output: 4
    Explanation: You can allocate to the first, second and third child with 
    1, 2, 1 candies respectively.
    The third child gets 1 candy because it satisfies both conditions.
*/

import java.util.*;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // 🍬 Each child gets at least 1 candy

        // 👉 Left to right: ensure right child gets more if rating is higher
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 👉 Right to left: ensure left child gets more if rating is higher
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // 🧮 Sum total candies
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }

        return total;
    }
}

/*
🧠 Approach (Greedy - 2 Pass):
   - Step 1: Give each child 1 candy.
   - Step 2: Traverse left → right. If current > previous rating, give +1 candy.
   - Step 3: Traverse right → left. If current > next rating, update candies with max value.
   - Step 4: Sum all candies for the result.

🛠️ Time Complexity: O(n)
🛠️ Space Complexity: O(n)
✅ Status: Accepted on LeetCode
*/
