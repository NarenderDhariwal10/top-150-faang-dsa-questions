// 🔍 Problem: Sliding Window Maximum (Heap Version)
// 📝 Link: https://leetcode.com/problems/sliding-window-maximum/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Amazon, Google, Microsoft, Facebook, Bloomberg

/*
👨‍💻 Problem Statement:
You are given an array of integers `nums`, and a sliding window of size `k` 
which moves from the very left of the array to the very right.
Return the max sliding window values for each move.

🧾 Example:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
*/

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Max Heap using custom comparator: sort by value (descending)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Initialize heap with first k elements
        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{nums[i], i}); // {value, index}
        }

        result[0] = maxHeap.peek()[0]; // max of first window

        for (int i = k; i < n; i++) {
            maxHeap.offer(new int[]{nums[i], i});

            // Remove elements from heap that are out of the window (index < i - k + 1)
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }

            result[i - k + 1] = maxHeap.peek()[0];
        }

        return result;
    }
}

/*
🧠 Approach:
- Use a Max Heap to track the maximum element in the current sliding window.
- Each element is stored as a pair of {value, index}.
- Remove top elements from heap if their index is outside the current window.
- Top of the heap always gives the current maximum in O(1) time.

🛠️ Time Complexity: O(n log k)
    - n: number of elements in nums
    - log k: insertion and deletion from heap of size k
🛠️ Space Complexity: O(k) for the heap

✅ Status: Accepted on LeetCode
*/
