// 🔍 Problem: Sliding Window Maximum
// 📝 Link: https://leetcode.com/problems/sliding-window-maximum/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Amazon, Google, Microsoft

/*
👨‍💻 Problem Statement:
Given an array `nums` and a sliding window size `k`, return the maximum value in each sliding window of size `k` as it moves from left to right.

🧾 Example:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]

Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

*/

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indices out of window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller values as they're not useful
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Add max to result once the first window is formed
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
/*
🧠 Approach:
- Use a double-ended queue (deque) to store indices of elements.
- Maintain the deque in decreasing order of values.
- Remove indices out of the current window.
- The front of the deque always contains the index of the maximum element for the current window.

🛠️ Time Complexity: O(n) – each element is added and removed at most once.
🛠️ Space Complexity: O(k) – deque size is limited to window size.
*/
