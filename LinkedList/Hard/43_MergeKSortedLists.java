// 🔍 Problem: Merge k Sorted Lists
// 📝 Link: https://leetcode.com/problems/merge-k-sorted-lists/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Amazon, Google, Microsoft, Facebook

/*
👨‍💻 Problem Statement:
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

🧾 Example:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]

Explanation:
- The final merged list contains all the nodes from all lists in ascending order.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return dummy.next;
    }
}

/*
🧠 Approach:
- Use a Min Heap (PriorityQueue) to always get the smallest node across all lists.
- Push the first node of each list into the heap.
- Poll the smallest node and attach it to the result list.
- If the polled node has a next node, push it into the heap.
- Repeat until the heap is empty.

🛠️ Time Complexity: O(N log k), where N is the total number of nodes and k is the number of lists.
🛠️ Space Complexity: O(k) for the heap

✅ Status: Accepted on LeetCode
*/
