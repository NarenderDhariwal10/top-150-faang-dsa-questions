// 🔍 Problem: Max Consecutive Ones III
// 📝 Link: https://leetcode.com/problems/max-consecutive-ones-iii/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Facebook

/*
👨‍💻 Problem Statement:
You are given a binary array `nums` and an integer `k`.
Return the maximum number of consecutive 1's in the array if you can flip at most `k` 0's.

🧾 Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: Flip the two zeros at indices 3 and 4 to get [1,1,1,1,1,0,1,1,1,1,0].

🧾 Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, maxLen = 0, zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

/*
🧠 Approach:
- Use a sliding window with two pointers `left` and `right`.
- Expand the window by moving `right`, counting zeros.
- If zero count exceeds `k`, move `left` until zeros ≤ `k`.
- Keep track of the maximum window length found.

🛠️ Time Complexity: O(n) – each element is processed at most twice.
🛠️ Space Complexity: O(1) – constant extra space used.
✅ Status: Ready to push — file name: 1004_MaxConsecutiveOnesIII.java
*/
