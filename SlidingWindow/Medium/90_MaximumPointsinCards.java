// 🔍 Problem: Maximum Points You Can Obtain from Cards
// 📝 Link: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google

/*
👨‍💻 Problem Statement:
There are several cards arranged in a row, and each card has an associated point value.
In one move, you can take one card from the beginning or the end of the row.
You must take exactly `k` cards.

Your task is to return the maximum score you can obtain.

🧾 Example 1:
Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: Take cards from the end: 6, 5, and 1.

🧾 Example 2:
Input: cardPoints = [2,2,2], k = 2
Output: 4
*/

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;

        // Calculate total points of first k cards
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }

        int maxScore = total;

        // Use sliding window: replace cards from the front with cards from the back
        for (int i = 0; i < k; i++) {
            total = total - cardPoints[k - 1 - i] + cardPoints[n - 1 - i];
            maxScore = Math.max(maxScore, total);
        }

        return maxScore;
    }
}

/*
🧠 Approach:
- Initially take the sum of the first `k` cards.
- Then, iteratively replace cards from the front with cards from the back to see if we get a higher score.
- Keep track of the maximum sum found.

🛠️ Time Complexity: O(k) – we only iterate over at most `k` elements twice.
🛠️ Space Complexity: O(1) – constant extra space.
✅ Status: Accepted on LeetCode
*/
