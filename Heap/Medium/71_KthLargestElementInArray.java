// 🔍 Problem: Kth Largest Element in an Array
// 📝 Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Microsoft, Google, Facebook

/*
👨‍💻 Problem Statement:
Given an integer array `nums` and an integer `k`, return the `kth` largest element in the array.

Note that it is the kth largest element **in sorted order**, not the kth distinct element.

🧾 Example:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min heap of size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            // If heap grows beyond k, remove smallest
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The top of the heap is the kth largest element
        return minHeap.peek();
    }
}

/*
🧠 Approach:
- Use a min heap to keep track of the k largest elements.
- Add each element to the heap.
- If the heap size exceeds k, remove the smallest element.
- At the end, the top of the heap is the kth largest element.

🛠️ Time Complexity: O(n log k)
🛠️ Space Complexity: O(k)

✅ Status: Accepted on LeetCode
*/
