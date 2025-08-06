// 🔍 Problem: Top K Frequent Elements
// 📝 Link: https://leetcode.com/problems/top-k-frequent-elements/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Amazon, Google, Facebook, Microsoft

/*
👨‍💻 Problem Statement:
Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.
You may return the answer in any order.

🧾 Example:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Input: nums = [1], k = 1
Output: [1]

*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies using a HashMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a min-heap to keep top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }

        // Step 3: Extract top k elements from heap
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().getKey();
        }

        return result;
    }
}

/*
🧠 Approach:
- Count frequency of each number using a HashMap.
- Use a Min Heap (PriorityQueue) of size k to store the most frequent elements.
- Heap ensures O(log k) insertion, so total complexity remains better than O(n log n).

🛠️ Time Complexity: O(n log k)
🛠️ Space Complexity: O(n)

✅ Status: Accepted on LeetCode
*/
