// 🔍 Problem: Merge k Sorted Lists
// 📝 Link: https://leetcode.com/problems/merge-k-sorted-lists/
// 🎯 Difficulty: Hard
// 🏢 Asked in: Amazon, Google, Microsoft, Adobe, Facebook

/*
👨‍💻 Problem Statement:
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

🧾 Example:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]

🔗 Explanation:
The merged linked list will be: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
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
        // Min-heap to store the nodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Add the head of each list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // Dummy head for the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge the nodes
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }
}

/*
🧠 Approach:
- Use a min-heap (priority queue) to always get the smallest head node among the k lists.
- Add the head of each list to the heap.
- Pop the smallest node, add it to result, and push its next node (if exists) to the heap.

🛠️ Time Complexity: O(N log k), where N = total number of nodes, k = number of lists
🛠️ Space Complexity: O(k) for the heap

✅ Status: Accepted on LeetCode
*/
