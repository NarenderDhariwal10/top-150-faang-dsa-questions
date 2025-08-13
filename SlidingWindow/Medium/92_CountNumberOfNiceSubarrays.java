// 🔍 Problem: Count Number of Nice Subarrays
// 📝 Link: https://leetcode.com/problems/count-number-of-nice-subarrays/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google

/*
👨‍💻 Problem Statement:
Given an array of integers `nums` and an integer `k`, return the number of good subarrays of `nums`.
A good array is one where the number of odd numbers is exactly `k`.

🧾 Example 1:
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: There are only two subarrays with exactly 3 odd numbers: [1,1,2,1] and [1,2,1,1].

🧾 Example 2:
Input: nums = [2,4,6], k = 1
Output: 0

🧾 Example 3:
Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
*/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                k--;
            }
            while (k < 0) {
                if (nums[left] % 2 != 0) {
                    k++;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}

/*
🧠 Approach:
- Use a helper method to count subarrays with at most `k` odd numbers.
- The number of subarrays with exactly `k` odd numbers =
  atMost(nums, k) − atMost(nums, k − 1).
- Sliding window ensures O(n) complexity.

🛠️ Time Complexity: O(n) – each element is processed at most twice.
🛠️ Space Complexity: O(1) – only pointers and counters used.
✅ Status: Ready to push — file name: 1248_CountNumberOfNiceSubarrays.java
*/
