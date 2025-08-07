// 🔍 Problem: Find Median from Data Stream
// 📝 Link: https://leetcode.com/problems/find-median-from-data-stream/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Google, Amazon, Facebook, Microsoft

/*
👨‍💻 Problem Statement:
The MedianFinder class should support the following two operations:
1. void addNum(int num) - Add a number into the data structure.
2. double findMedian() - Return the median of all elements so far.

The median is:
- The middle element for an odd number of elements.
- The average of the two middle elements for even number of elements.

🧾 Example:
Input:
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]

Output:
[null, null, null, 1.5, null, 2.0]
*/

class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // left half (lower numbers)
    private PriorityQueue<Integer> minHeap; // right half (higher numbers)

    public MedianFinder() {
        // Max heap for the smaller half
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Min heap for the larger half
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add to maxHeap first
        maxHeap.add(num);

        // Step 2: Balance the two heaps - move the largest of maxHeap to minHeap
        minHeap.add(maxHeap.poll());

        // Step 3: Keep maxHeap always bigger or equal to minHeap in size
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // Even number of elements
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // Odd number of elements
            return maxHeap.peek();
        }
    }
}

/*
🧠 Approach:
- Use two heaps:
  1. MaxHeap (for the lower half)
  2. MinHeap (for the upper half)
- Always keep MaxHeap's size >= MinHeap.
- Median is:
   - maxHeap.peek() if odd number of elements.
   - Average of both heap tops if even.

🛠️ Time Complexity:
- addNum: O(log n)
- findMedian: O(1)

🛠️ Space Complexity: O(n)

✅ Status: Accepted on LeetCode
*/
