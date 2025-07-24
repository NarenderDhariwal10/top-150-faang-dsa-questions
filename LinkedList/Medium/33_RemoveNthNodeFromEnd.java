// 🔍 Problem: Remove Nth Node From End of List
// 📝 Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// 🎯 Difficulty: Medium
// 🏢 Asked in: Oracle, Facebook, Microsoft

/*
👨‍💻 Problem Statement:
Given the head of a linked list, remove the nth node from the end of the list and return its head.

🧾 Example:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Input: head = [1], n = 1
Output: []

Input: head = [1,2], n = 1
Output: [1]
*/

public class Solution {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // First and second pointers start at dummy
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move first n+1 steps ahead so second is just before the node to delete
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove the nth node
        second.next = second.next.next;
        
        return dummy.next; // Return new head
    }
}

/*
🧠 Approach:
- Use two-pointer technique: Move the first pointer n+1 steps ahead.
- Then move both pointers together until the first reaches the end.
- The second pointer will be just before the target node to delete.
- Modify the next of the second pointer to skip the target node.

🛠️ Time Complexity: O(L), where L is the length of the list
🛠️ Space Complexity: O(1)

✅ Status: Accepted on LeetCode
*/
